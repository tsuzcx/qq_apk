package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectMemberActivity$GridViewAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public SelectMemberActivity$GridViewAdapter(SelectMemberActivity paramSelectMemberActivity, Context paramContext)
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842403);
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      return;
    }
    catch (IndexOutOfBoundsException paramSelectMemberActivity)
    {
      for (;;)
      {
        QLog.d("SelectMemberActivity", 1, "GridViewAdapter getDrawable exception");
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size() > 0))
      {
        String str = ((ResultRecord)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size() - 1)).jdField_a_of_type_JavaLangString;
        ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size() - 1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e(str);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localResultRecord, false);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j();
          int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
          if ((i == 6) || (i == 7) || (i == 5) || (i == 4) || (i == 1) || (i == 0) || (i == 8) || (i == 9)) {
            ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
          }
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(false);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.notifyDataSetChanged();
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)paramList.next();
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.contains(localResultRecord)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.add(localResultRecord);
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130969036, null);
    }
    paramViewGroup.setTag(localResultRecord);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131362744);
    if (paramInt == getCount() - 1) {
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localImageView.setImageDrawable(paramView);
        label75:
        localImageView.setBackgroundDrawable(null);
        if (localResultRecord.jdField_a_of_type_Int != 4) {
          break label171;
        }
      }
    }
    TextView localTextView;
    label171:
    for (paramInt = 11;; paramInt = 1)
    {
      localTextView = (TextView)paramViewGroup.findViewById(2131363965);
      if (localResultRecord.jdField_a_of_type_Int != 5) {
        break label176;
      }
      localImageView.setImageResource(2130840204);
      localTextView.setVisibility(0);
      localTextView.setText(ContactUtils.a(localResultRecord.b));
      if (AppSetting.b) {
        localImageView.setContentDescription(localResultRecord.b);
      }
      return paramViewGroup;
      paramView = null;
      break;
      localImageView.setImageDrawable(null);
      break label75;
    }
    label176:
    String str = localResultRecord.jdField_a_of_type_JavaLangString;
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, str);
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, paramInt, true);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b;
    }
    for (;;)
    {
      localImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramView));
      localTextView.setVisibility(8);
      break;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetGridView == null) {}
    for (;;)
    {
      return;
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetGridView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetGridView.getChildAt(paramInt1);
        Object localObject = localView.getTag();
        if ((localObject != null) && ((localObject instanceof ResultRecord)) && (paramString.equals(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))) {
          ((ImageView)localView.findViewById(2131362744)).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */