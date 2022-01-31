package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import wcn;

public class ComicTipsBar
  implements TipsBarTask
{
  int jdField_a_of_type_Int = -1;
  public Activity a;
  public TipsManager a;
  public QQAppInterface a;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  public String b = "";
  String c = "";
  
  public ComicTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public int a()
  {
    return 35;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130968664, null);
    localView.setOnClickListener(new wcn(this, localView));
    TextView localTextView = (TextView)localView.findViewById(2131363089);
    paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    int j = (int)(localTextView.getPaint().measureText(this.c) / this.c.length());
    int i;
    if (paramVarArgs.widthPixels > paramVarArgs.heightPixels)
    {
      i = paramVarArgs.heightPixels;
      i = (int)((i - paramVarArgs.density * 65.0F) / j) - 8;
      if (this.c.length() > i) {
        this.c = (this.c.substring(0, i) + "...");
      }
      if ((this.jdField_a_of_type_Int < 100) || (this.jdField_a_of_type_Int > 300)) {
        break label213;
      }
    }
    label213:
    for (paramVarArgs = "正在观看《%s》";; paramVarArgs = "正在阅读《%s》")
    {
      this.jdField_a_of_type_JavaLangString = String.format(paramVarArgs, new Object[] { this.c });
      localTextView.setText(this.jdField_a_of_type_JavaLangString);
      return localView;
      i = paramVarArgs.widthPixels;
      break;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ComicTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
          }
          paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
          if (paramVarArgs != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ComicTipsBar", 2, "onAIOEvent() : data == null");
        return;
        this.jdField_a_of_type_Boolean = paramVarArgs.getBoolean("fromMessage", false);
        this.b = paramVarArgs.getString("comicId");
        this.c = paramVarArgs.getString("comicName");
        this.jdField_a_of_type_Int = paramVarArgs.getInt("type", -1);
        if (!TextUtils.isEmpty(this.c)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ComicTipsBar", 2, "onAIOEvent() : comicName is null");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
    } while (!QLog.isColorLevel());
    QLog.d("ComicTipsBar", 2, "onAIOEvent() : show ReaderTipBar, bookName : " + this.c);
  }
  
  public int[] a()
  {
    return new int[0];
  }
  
  public int b()
  {
    return 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ComicTipsBar
 * JD-Core Version:    0.7.0.1
 */