import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.DiscussionMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class amdj
  extends amnl
{
  private LinkedHashMap<String, List<DiscussionMemberInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public amdj(DiscussionMemberListInnerFrame paramDiscussionMemberListInnerFrame)
  {
    super(paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    b();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    bkgt localbkgt = (bkgt)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(165);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    Object localObject3;
    label163:
    int i;
    while (localIterator.hasNext())
    {
      localObject3 = (DiscussionMemberInfo)localIterator.next();
      if ((localObject3 == null) || (!localbkgt.f(((DiscussionMemberInfo)localObject3).memberUin))) {
        if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.u) && (str != null) && (str.equals(((DiscussionMemberInfo)localObject3).memberUin)))
        {
          localObject1 = localObject3;
        }
        else
        {
          if ((((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst == null) || (((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst.length() == 0))
          {
            localObject2 = "#";
            i = ((String)localObject2).charAt(0);
            if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
              break label268;
            }
          }
          label268:
          for (localObject2 = ((String)localObject2).toUpperCase();; localObject2 = "#")
          {
            if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2) == null) {
              this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject2, new ArrayList());
            }
            ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2)).add(localObject3);
            break;
            localObject2 = ((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst.substring(0, 1);
            break label163;
          }
        }
      }
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.u) && (localObject1 != null))
    {
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(localObject1);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(anzj.a(2131702255), localObject3);
    }
    for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
      if (((LinkedHashMap)localObject2).get(String.valueOf(c)) != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), ((LinkedHashMap)localObject2).get(String.valueOf(c)));
      }
    }
    if (((LinkedHashMap)localObject2).get("#") != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject2).get("#"));
    }
    ((LinkedHashMap)localObject2).clear();
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      i = 1;
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
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559317;
    }
    return 0;
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
  
  public void a()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localIterator.next())).size() + i) {}
    return i;
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
    return (DiscussionMemberInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    amdk localamdk;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562901, paramViewGroup, false);
      localamdk = new amdk(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame, null);
      paramView.setTag(localamdk);
      localamdk.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376813));
      localamdk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379901));
      localamdk.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364511));
      localamdk.c = ((ImageView)paramView.findViewById(2131368212));
      localamdk.b = ((TextView)paramView.findViewById(2131371647));
    }
    for (;;)
    {
      localamdk = (amdk)paramView.getTag();
      Object localObject;
      if (i < 0)
      {
        i = -(i + 1) - 1;
        localObject = (DiscussionMemberInfo)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(((DiscussionMemberInfo)localObject).memberUin))
        {
          localamdk.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          localamdk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          localamdk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localamdk.c.setImageBitmap(a(((DiscussionMemberInfo)localObject).memberUin));
          localamdk.b.setText(bhlg.a((DiscussionMemberInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          localamdk.jdField_a_of_type_JavaLangString = ((DiscussionMemberInfo)localObject).memberUin;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(((DiscussionMemberInfo)localObject).memberUin))) {
            break label418;
          }
          localamdk.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          label316:
          if ((AppSetting.c) && (localamdk.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
          {
            if (!localamdk.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label430;
            }
            paramView.setContentDescription(bhlg.a((DiscussionMemberInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + anzj.a(2131702261));
          }
          label382:
          paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localamdk.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        label418:
        localamdk.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label316;
        label430:
        paramView.setContentDescription(bhlg.a((DiscussionMemberInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + anzj.a(2131702244));
        break label382;
        localamdk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localamdk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localamdk.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localamdk.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691638), new Object[] { ((String)localObject).toLowerCase() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdj
 * JD-Core Version:    0.7.0.1
 */