package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import java.net.URL;

public class LocalMediaGridAdapter$VideoHolder
  extends LocalMediaGridAdapter.ImageHolder
{
  public TextView a;
  public View b;
  
  public LocalMediaGridAdapter$VideoHolder(LocalMediaGridAdapter paramLocalMediaGridAdapter, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramLocalMediaGridAdapter, paramViewGroup, paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380325));
    this.jdField_b_of_type_AndroidViewView = a(2131380894);
  }
  
  protected URL a(String paramString)
  {
    return AsyncImageView.a(paramString, this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight(), false);
  }
  
  public void a(int paramInt, AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramInt, paramLocalMediaInfo);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a((int)(paramLocalMediaInfo.d / 1000L)));
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.LocalMediaGridAdapter.VideoHolder
 * JD-Core Version:    0.7.0.1
 */