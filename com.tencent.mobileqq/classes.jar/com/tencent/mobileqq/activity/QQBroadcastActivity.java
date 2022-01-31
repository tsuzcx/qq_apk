package com.tencent.mobileqq.activity;

import abor;
import adla;
import adlb;
import aljq;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Observer;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  public adlb a;
  public Handler a;
  
  public QQBroadcastActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new adla(this);
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
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131720570) + "(" + i + ")"));
      return;
      label79:
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131720570)));
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
    if (this.jdField_a_of_type_Adlb == null) {
      this.jdField_a_of_type_Adlb = new adlb(this, this, this.app.a(0).a(a(), 0));
    }
    return this.jdField_a_of_type_Adlb;
  }
  
  protected CharSequence a()
  {
    return getString(2131720519);
  }
  
  public String a()
  {
    return String.valueOf(aljq.J);
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
    if (this.jdField_a_of_type_Adlb != null) {
      this.jdField_a_of_type_Adlb.changeCursor(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */