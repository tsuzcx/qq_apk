package com.dataline.util;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

public class ItemHolder
  implements Cloneable
{
  public ImageView a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ItemHolder.FileItemHolder jdField_a_of_type_ComDatalineUtilItemHolder$FileItemHolder = new ItemHolder.FileItemHolder(this);
  private ItemHolder.GrayTipItemHolder jdField_a_of_type_ComDatalineUtilItemHolder$GrayTipItemHolder = new ItemHolder.GrayTipItemHolder(this);
  private ItemHolder.ImageItemHolder jdField_a_of_type_ComDatalineUtilItemHolder$ImageItemHolder = new ItemHolder.ImageItemHolder(this);
  private ItemHolder.MutiImageItemHolder jdField_a_of_type_ComDatalineUtilItemHolder$MutiImageItemHolder = new ItemHolder.MutiImageItemHolder(this);
  private ItemHolder.TextItemHolder jdField_a_of_type_ComDatalineUtilItemHolder$TextItemHolder = new ItemHolder.TextItemHolder(this);
  public BubbleInfo a;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private Object jdField_a_of_type_JavaLangObject;
  private TextView b;
  
  public ProgressBar a()
  {
    return this.jdField_a_of_type_AndroidWidgetProgressBar;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public ItemHolder.FileItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilItemHolder$FileItemHolder;
  }
  
  public ItemHolder.GrayTipItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilItemHolder$GrayTipItemHolder;
  }
  
  public ItemHolder.ImageItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilItemHolder$ImageItemHolder;
  }
  
  public ItemHolder.MutiImageItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilItemHolder$MutiImageItemHolder;
  }
  
  public ItemHolder.TextItemHolder a()
  {
    return this.jdField_a_of_type_ComDatalineUtilItemHolder$TextItemHolder;
  }
  
  public DataLineMsgSet a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(ProgressBar paramProgressBar)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = paramProgressBar;
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(DataLineMsgSet paramDataLineMsgSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public TextView b()
  {
    return this.b;
  }
  
  public void b(TextView paramTextView)
  {
    this.b = paramTextView;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isDevelopLevel());
      QLog.w("Dataline.ItemHolder", 4, "ItemHolder clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.util.ItemHolder
 * JD-Core Version:    0.7.0.1
 */