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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ComicTipsBar
  implements TipsBarTask
{
  int jdField_a_of_type_Int = -1;
  Activity jdField_a_of_type_AndroidAppActivity;
  TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String b = "";
  String c = "";
  
  public ComicTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity)
  {
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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558586, null);
    localView.setOnClickListener(new ComicTipsBar.1(this, localView));
    TextView localTextView = (TextView)localView.findViewById(2131362510);
    paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    int j = (int)(localTextView.getPaint().measureText(this.c) / this.c.length());
    if (paramVarArgs.widthPixels > paramVarArgs.heightPixels) {
      i = paramVarArgs.heightPixels;
    } else {
      i = paramVarArgs.widthPixels;
    }
    int i = (int)((i - paramVarArgs.density * 65.0F) / j) - 8;
    if (this.c.length() > i)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(this.c.substring(0, i));
      paramVarArgs.append("...");
      this.c = paramVarArgs.toString();
    }
    i = this.jdField_a_of_type_Int;
    if ((i >= 100) && (i <= 300)) {
      paramVarArgs = HardCodeUtil.a(2131702357);
    } else {
      paramVarArgs = HardCodeUtil.a(2131702358);
    }
    this.jdField_a_of_type_JavaLangString = String.format(paramVarArgs, new Object[] { this.c });
    localTextView.setText(this.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComicTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    paramVarArgs = this.jdField_a_of_type_AndroidAppActivity;
    if ((paramVarArgs != null) && (paramVarArgs.getIntent() != null))
    {
      paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      if (paramVarArgs == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComicTipsBar", 2, "onAIOEvent() : data == null");
        }
        return;
      }
      this.jdField_a_of_type_Boolean = paramVarArgs.getBoolean("fromMessage", false);
      this.b = paramVarArgs.getString("comicId");
      this.c = paramVarArgs.getString("comicName");
      this.jdField_a_of_type_Int = paramVarArgs.getInt("type", -1);
      if (TextUtils.isEmpty(this.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComicTipsBar", 2, "onAIOEvent() : comicName is null");
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("onAIOEvent() : show ReaderTipBar, bookName : ");
        paramVarArgs.append(this.c);
        QLog.d("ComicTipsBar", 2, paramVarArgs.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComicTipsBar", 2, "onAIOEvent() : intent is null");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ComicTipsBar
 * JD-Core Version:    0.7.0.1
 */