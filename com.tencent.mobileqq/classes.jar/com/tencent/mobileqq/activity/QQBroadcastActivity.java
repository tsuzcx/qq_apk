package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.Observer;
import tia;
import tib;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  public Handler a;
  public tib a;
  
  public QQBroadcastActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new tia(this);
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
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131433297) + "(" + i + ")"));
      return;
      label79:
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131433297)));
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
    if (this.jdField_a_of_type_Tib == null) {
      this.jdField_a_of_type_Tib = new tib(this, this, this.app.a(0).a(a(), 0));
    }
    return this.jdField_a_of_type_Tib;
  }
  
  protected CharSequence a()
  {
    return getString(2131434941);
  }
  
  public String a()
  {
    return String.valueOf(AppConstants.H);
  }
  
  protected void a()
  {
    c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app.a().c(a(), 0);
    c();
    this.rightViewText.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Tib != null) {
      this.jdField_a_of_type_Tib.changeCursor(null);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */