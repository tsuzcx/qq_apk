package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SelectedAndSearchBar$GridViewAdapter
  extends BaseAdapter
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SelectedAndSearchBar$GridViewAdapter(SelectedAndSearchBar paramSelectedAndSearchBar)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = SelectedAndSearchBar.a(paramSelectedAndSearchBar).getResources().getDrawable(2130845076);
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();
  }
  
  private int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1006) {
      i = 11;
    }
    do
    {
      return i;
      if (paramInt == 1) {
        return 4;
      }
    } while (paramInt != 3000);
    return 101;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar) != null) && (SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).size() > 0))
      {
        ResultRecord localResultRecord = (ResultRecord)SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).get(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).size() - 1);
        if (SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar) != null) {
          SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).a(localResultRecord);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(false);
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).size();
  }
  
  public Object getItem(int paramInt)
  {
    return SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar)).inflate(2131559402, null);
    }
    for (;;)
    {
      paramView.setTag(localResultRecord);
      ImageView localImageView = (ImageView)paramView.findViewById(2131366520);
      int i;
      label97:
      int j;
      if (paramInt == getCount() - 1)
      {
        if (this.jdField_a_of_type_Boolean) {
          localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        localImageView.setImageDrawable((Drawable)localObject);
        if (localResultRecord.getUinType() != -1) {
          break label207;
        }
        i = localResultRecord.type;
        if (localResultRecord.type != -1) {
          break label221;
        }
        j = i;
        label110:
        localResultRecord.type = j;
        if (!AppConstants.DATALINE_PC_UIN.equals(localResultRecord.uin)) {
          break label231;
        }
        localImageView.setBackgroundResource(2130844376);
      }
      for (;;)
      {
        if (AppSetting.d) {
          localImageView.setContentDescription(localResultRecord.name);
        }
        if (SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar) == 1) {
          QQGameTroopManager.a((ImageView)paramView.findViewById(2131369671), localResultRecord.uin);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageDrawable(null);
        break;
        label207:
        i = a(localResultRecord.getUinType());
        break label97;
        label221:
        j = localResultRecord.type;
        break label110;
        label231:
        if (AppConstants.DATALINE_IPAD_UIN.equals(localResultRecord.uin))
        {
          localImageView.setBackgroundResource(2130844371);
        }
        else if (AppConstants.DATALINE_PRINTER_UIN.equals(localResultRecord.uin))
        {
          localImageView.setBackgroundResource(2130844379);
        }
        else if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(localResultRecord.uin))
        {
          localImageView.setBackgroundResource(2130839708);
        }
        else
        {
          if (localResultRecord.type != 5) {
            break label322;
          }
          localImageView.setImageResource(2130842261);
        }
      }
      label322:
      String str = localResultRecord.uin;
      localObject = SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).getBitmapFromCache(i, str);
      if (localObject == null)
      {
        SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).requestDecodeFace(str, i, true);
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      for (;;)
      {
        localImageView.setBackgroundDrawable(new BitmapDrawable(SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).getResources(), (Bitmap)localObject));
        break;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SelectedAndSearchBar.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */