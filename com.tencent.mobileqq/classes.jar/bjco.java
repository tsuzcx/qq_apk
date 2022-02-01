import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.DeviceFriendListOpenFrame;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class bjco
  extends birb
{
  protected LinkedHashMap<String, List<Friend>> a;
  protected int[] a;
  protected String[] a;
  
  public bjco(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    a();
  }
  
  public int a()
  {
    return 2131559369;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.jdField_a_of_type_Bjgp.a();
    bjko.c(DeviceFriendListOpenFrame.jdField_a_of_type_JavaLangString, "-->start constructHashStruct()");
    Object localObject2 = ((List)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      Friend localFriend = (Friend)((Iterator)localObject2).next();
      if ((localFriend.f == null) || (localFriend.f.length() == 0))
      {
        localObject1 = "#";
        label81:
        i = ((String)localObject1).charAt(0);
        if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
          break label186;
        }
      }
      label186:
      for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localFriend);
        break;
        localObject1 = localFriend.f.substring(0, 1);
        break label81;
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
    bjko.c(DeviceFriendListOpenFrame.jdField_a_of_type_JavaLangString, "-->end constructHashStruct()");
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
    View localView;
    Object localObject;
    label192:
    label234:
    Bitmap localBitmap;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562851, paramViewGroup, false);
      paramView = new bjcp();
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376837));
      paramView.c = ((TextView)localView.findViewById(2131379987));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364612));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368381));
      paramView.d = ((TextView)localView.findViewById(2131371803));
      localView.setTag(paramView);
      if (i >= 0) {
        break label465;
      }
      i = -(i + 1) - 1;
      localObject = (Friend)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      if (!this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.jdField_a_of_type_Bjgp.a(((Friend)localObject).jdField_a_of_type_JavaLangString)) {
        break label416;
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if ((this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a == null) || (!this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a.contains(((Friend)localObject).jdField_a_of_type_JavaLangString))) {
        break label427;
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      if ((((Friend)localObject).d == null) || ("".equals(((Friend)localObject).d))) {
        ((Friend)localObject).d = bjgw.a(this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), ((Friend)localObject).jdField_a_of_type_JavaLangString);
      }
      paramView.jdField_b_of_type_JavaLangString = ((Friend)localObject).d;
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.c.setVisibility(8);
      localBitmap = bjgt.a().a(((Friend)localObject).d);
      if (localBitmap != null) {
        break label438;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840348);
      bjgt.a().a(((Friend)localObject).d, this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame);
      label347:
      if ((((Friend)localObject).c != null) && (!"".equals(((Friend)localObject).c))) {
        break label450;
      }
      paramView.d.setText(((Friend)localObject).jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bjcp)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label416:
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label192;
      label427:
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      break label234;
      label438:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      break label347;
      label450:
      paramView.d.setText(((Friend)localObject).c);
      continue;
      label465:
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramView.c.setVisibility(0);
      paramView.c.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjco
 * JD-Core Version:    0.7.0.1
 */