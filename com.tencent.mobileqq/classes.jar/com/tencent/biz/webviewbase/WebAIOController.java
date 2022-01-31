package com.tencent.biz.webviewbase;

import android.content.BroadcastReceiver;
import android.widget.ImageView;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import pax;
import pay;

public class WebAIOController
{
  public static volatile boolean b;
  public static volatile boolean c;
  int jdField_a_of_type_Int = 2130846383;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new pax(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  Client.onRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new pay(this);
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  String jdField_b_of_type_JavaLangString = "";
  int jdField_c_of_type_Int = 360000;
  String jdField_c_of_type_JavaLangString = "";
  int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString = "";
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewbase.WebAIOController
 * JD-Core Version:    0.7.0.1
 */