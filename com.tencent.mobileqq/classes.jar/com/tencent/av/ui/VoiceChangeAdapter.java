package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.AVLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VoiceChangeAdapter
  extends BaseAdapter
{
  public static String a = "VoiceChangeAdapter";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private VoiceChangeAdapter.ICallback jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter$ICallback;
  VoiceChangeItemView1.ICallback jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback;
  private VoiceChangeItemView1 jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1;
  private VoiceChangeData.VoiceInfo[] jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo;
  private int jdField_b_of_type_Int;
  private VoiceChangeItemView1 jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
  private int c;
  private int d;
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(VoiceChangeData.VoiceInfo[] paramArrayOfVoiceInfo)
  {
    this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = paramArrayOfVoiceInfo;
  }
  
  public int getCount()
  {
    VoiceChangeData.VoiceInfo[] arrayOfVoiceInfo = this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo;
    if (arrayOfVoiceInfo == null) {
      return 0;
    }
    return arrayOfVoiceInfo.length;
  }
  
  public Object getItem(int paramInt)
  {
    VoiceChangeData.VoiceInfo[] arrayOfVoiceInfo = this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo;
    if (arrayOfVoiceInfo == null) {
      return null;
    }
    return arrayOfVoiceInfo[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getView|position=");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(", view=");
    ((StringBuilder)localObject2).append(paramView);
    AVLog.printDebugLog((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = paramView;
    if (paramView == null) {
      localObject1 = new VoiceChangeItemView1(this.jdField_a_of_type_AndroidContentContext);
    }
    paramView = (VoiceChangeData.VoiceInfo)getItem(paramInt);
    if (paramView != null)
    {
      if ((this.d == 0) && (paramInt == 1) && (this.jdField_b_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
      }
      localObject2 = (VoiceChangeItemView1)localObject1;
      boolean bool;
      if (this.c == paramView.jdField_a_of_type_Int) {
        bool = true;
      } else {
        bool = false;
      }
      ((VoiceChangeItemView1)localObject2).a(paramInt, paramView, bool, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback);
      if (this.c == paramView.jdField_a_of_type_Int)
      {
        if (paramInt != 0) {
          this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = ((VoiceChangeItemView1)localObject2);
        }
        this.d = paramInt;
      }
    }
    this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1 = ((VoiceChangeItemView1)localObject1);
    this.jdField_b_of_type_Int = paramInt;
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeAdapter
 * JD-Core Version:    0.7.0.1
 */