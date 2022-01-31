package com.tencent.biz.qqstory.takevideo.permission;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ole;
import olf;

public class ComplexPart
  extends PermissionPart
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  
  public ComplexPart(Context paramContext, String paramString, int paramInt, @NonNull List paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString, paramInt);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private olf a(int paramInt)
  {
    int i = c();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new olf(null);
      ((olf)localObject1).jdField_a_of_type_Int = 1;
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (ComplexPart.Group)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new olf(null);
        ((olf)localObject2).jdField_a_of_type_Int = 2;
        ((olf)localObject2).jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group = ((ComplexPart.Group)localObject1);
        return localObject2;
      }
      if (!ComplexPart.Group.a((ComplexPart.Group)localObject1)) {
        break label253;
      }
      if (paramInt <= ((ComplexPart.Group)localObject1).a().size() + i)
      {
        localObject2 = (ComplexPart.Friend)((ComplexPart.Group)localObject1).a().get(paramInt - i - 1);
        olf localolf = new olf(null);
        localolf.jdField_a_of_type_Int = 3;
        localolf.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group = ((ComplexPart.Group)localObject1);
        localolf.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Friend = ((ComplexPart.Friend)localObject2);
        return localolf;
      }
      i = ((ComplexPart.Group)localObject1).a().size() + i;
    }
    label253:
    for (;;)
    {
      break;
      throw new IllegalStateException("can not find item with innerPos:" + paramInt);
    }
  }
  
  private void a(View paramView)
  {
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131371925);
    Object localObject = (ImageView)paramView.findViewById(2131364389);
    TextView localTextView = (TextView)paramView.findViewById(2131364390);
    paramView = paramView.findViewById(2131364392);
    localTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      ((ImageView)localObject).setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (!this.b) {
        break label138;
      }
      localCheckBox.setChecked(true);
    }
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = -2170912;
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        i = -16444373;
      }
      paramView.setBackgroundColor(i);
      return;
      ((ImageView)localObject).setVisibility(4);
      break;
      label138:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, ComplexPart.Group paramGroup)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131363842);
    TextView localTextView2 = (TextView)paramView.findViewById(2131371929);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131371930);
    paramView = (CheckBox)paramView.findViewById(2131371928);
    localTextView1.setText(paramGroup.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(paramGroup.a()), Integer.valueOf(paramGroup.b()) }));
    if (paramGroup.b() == 0)
    {
      paramView.setVisibility(4);
      if (!paramGroup.a()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!ComplexPart.Group.a(paramGroup)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new ole(this, paramGroup));
      return;
      paramView.setVisibility(0);
      break;
      label146:
      paramView.setChecked(false);
      break label111;
      label154:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, ComplexPart.Group paramGroup, ComplexPart.Friend paramFriend)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131364606);
    Object localObject1 = (TextView)paramView.findViewById(2131364616);
    Object localObject2 = (CheckBox)paramView.findViewById(2131371926);
    paramView = paramView.findViewById(2131371927);
    ((TextView)localObject1).setText(paramFriend.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
    if (paramFriend.jdField_a_of_type_Boolean)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = ImageUtil.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label226;
      }
      localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramFriend.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilList.indexOf(paramGroup) == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramGroup = paramGroup.a();
        if (paramGroup.indexOf(paramFriend) == paramGroup.size() - 1)
        {
          int i = -2170912;
          QQStoryContext.a();
          if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
            i = -16444373;
          }
          paramView.setBackgroundColor(i);
          paramView.setVisibility(0);
        }
      }
      return;
      ((CheckBox)localObject2).setChecked(false);
      break;
      label207:
      SLog.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label226:
      SLog.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(olf paramolf)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean) {
      if (!this.b) {
        bool = true;
      }
    }
    for (this.b = bool;; this.b = true)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      bool = false;
      break;
    }
  }
  
  private void b(olf paramolf)
  {
    paramolf.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group.a();
  }
  
  private int c()
  {
    if (!this.b) {
      return 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      ComplexPart.Group localGroup = (ComplexPart.Group)localIterator.next();
      List localList = localGroup.a();
      i += 1;
      if (!ComplexPart.Group.a(localGroup)) {
        break label72;
      }
      i = localList.size() + i;
    }
    label72:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void c(olf paramolf)
  {
    paramolf.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group.a(paramolf.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Friend);
  }
  
  public int a()
  {
    return c();
  }
  
  public int a(int paramInt)
  {
    return a(paramInt).jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt).jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 1: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970793, null);
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970795, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970794, null);
  }
  
  @NonNull
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((ComplexPart.Group)localIterator.next()).b());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    olf localolf = a(paramInt);
    switch (localolf.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(localolf);
      return;
    case 2: 
      b(localolf);
      return;
    }
    c(localolf);
  }
  
  public void a(int paramInt, View paramView)
  {
    olf localolf = a(paramInt);
    switch (localolf.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 2: 
      a(paramView, localolf.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group);
      return;
    }
    a(paramView, localolf.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group, localolf.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Friend);
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      ComplexPart.Group localGroup = (ComplexPart.Group)localIterator1.next();
      Iterator localIterator2 = localGroup.a().iterator();
      while (localIterator2.hasNext())
      {
        ComplexPart.Friend localFriend = (ComplexPart.Friend)localIterator2.next();
        if (paramList.contains(localFriend.a())) {
          localGroup.b(localFriend);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.ComplexPart
 * JD-Core Version:    0.7.0.1
 */