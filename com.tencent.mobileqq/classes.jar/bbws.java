import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.FriendListOpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class bbws
  extends bblf
{
  protected LinkedHashMap<String, List<Friend>> a;
  protected int[] a;
  protected String[] a;
  
  public bbws(FriendListOpenFrame paramFriendListOpenFrame)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    a();
  }
  
  public int a()
  {
    return 2131493625;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_Bbzv.a(this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_Int);
    bcds.c("FriendListOpenFrame", "-->start constructHashStruct()");
    Object localObject2 = ((List)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      Friend localFriend = (Friend)((Iterator)localObject2).next();
      if ((localFriend.f == null) || (localFriend.f.length() == 0))
      {
        localObject1 = "#";
        label87:
        i = ((String)localObject1).charAt(0);
        if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
          break label192;
        }
      }
      label192:
      for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localFriend);
        break;
        localObject1 = localFriend.f.substring(0, 1);
        break label87;
      }
    }
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), ((LinkedHashMap)localObject1).get(String.valueOf(c)));
      }
    }
    if (((LinkedHashMap)localObject1).get("#") != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject1).get("#"));
    }
    ((LinkedHashMap)localObject1).clear();
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return;
    }
    this.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      int j = localObject2[i];
      int k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
      localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + 1 + j);
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
    bcds.c("FriendListOpenFrame", "-->end constructHashStruct()");
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return;
    }
    ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public void b()
  {
    a();
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    paramInt = paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1;
    if ((paramInt >= 0) && (paramInt < localList.size())) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    Friend localFriend;
    label185:
    label211:
    Bitmap localBitmap;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496808, paramViewGroup, false);
      paramViewGroup = new bbwt();
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131309645));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131312394));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131298635));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302061));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131304981));
      paramView.setTag(paramViewGroup);
      if (i >= 0) {
        break label417;
      }
      i = -(i + 1) - 1;
      localFriend = (Friend)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      if (!this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_Bbzv.a(localFriend.a)) {
        break label369;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (!this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_Bbzv.a(localFriend.a)) {
        break label380;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if ((localFriend.d == null) || ("".equals(localFriend.d))) {
        localFriend.d = bcac.a(this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), localFriend.a);
      }
      paramViewGroup.jdField_b_of_type_JavaLangString = localFriend.d;
      paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramViewGroup.c.setVisibility(8);
      localBitmap = bbzz.a().a(localFriend.d);
      if (localBitmap != null) {
        break label391;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839687);
      bbzz.a().a(localFriend.d, this.jdField_a_of_type_ComTencentOpenAgentFriendListOpenFrame);
    }
    for (;;)
    {
      if ((localFriend.c != null) && (!"".equals(localFriend.c))) {
        break label403;
      }
      paramViewGroup.d.setText(localFriend.jdField_b_of_type_JavaLangString);
      return paramView;
      paramViewGroup = (bbwt)paramView.getTag();
      break;
      label369:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label185;
      label380:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label211;
      label391:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    label403:
    paramViewGroup.d.setText(localFriend.c);
    return paramView;
    label417:
    paramViewGroup.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramViewGroup.c.setVisibility(0);
    paramViewGroup.c.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbws
 * JD-Core Version:    0.7.0.1
 */