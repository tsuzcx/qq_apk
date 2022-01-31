package com.tencent.mobileqq.activity;

import abts;
import abtt;
import ajsd;
import akpu;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.Observer;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  public abtt a;
  public Handler a;
  
  public QQBroadcastActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new abts(this);
  }
  
  private void c()
  {
    int i = 999;
    QQMessageFacade localQQMessageFacade = this.app.a();
    int j;
    if (localQQMessageFacade != null)
    {
      j = localQQMessageFacade.b();
      if (j <= 0) {
        break label79;
      }
      if (j <= 999) {
        break label99;
      }
    }
    for (;;)
    {
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131720034) + "(" + i + ")"));
      return;
      label79:
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131720034)));
      return;
      label99:
      i = j;
    }
  }
  
  public Cursor a()
  {
    return this.app.a(0).a(a(), 0);
  }
  
  protected CursorAdapter a()
  {
    if (this.jdField_a_of_type_Abtt == null) {
      this.jdField_a_of_type_Abtt = new abtt(this, this, this.app.a(0).a(a(), 0));
    }
    return this.jdField_a_of_type_Abtt;
  }
  
  protected CharSequence a()
  {
    return getString(2131719984);
  }
  
  public String a()
  {
    return String.valueOf(ajsd.J);
  }
  
  protected void a()
  {
    c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app.a().c(a(), 0);
    c();
    this.rightViewText.setVisibility(8);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Abtt != null) {
      this.jdField_a_of_type_Abtt.changeCursor(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */