package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;

public class BaseSystemActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private static int e;
  private static Calendar f = ;
  private static StringBuffer g = new StringBuffer();
  CursorAdapter a;
  String b;
  HashMap<Long, Long> c = new HashMap();
  private XListView d;
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = g;
    int i = 0;
    localStringBuffer.setLength(0);
    f.setTimeInMillis(paramLong);
    int k = b(paramLong);
    if (k != -1)
    {
      if (k != 2131917319) {
        g.append(BaseApplication.getContext().getString(k));
      }
      i = 1;
    }
    int m = f.get(11);
    int j = f.get(12);
    if (i != 0)
    {
      if (k == 2131917319)
      {
        i = 24;
        if (m != 24) {
          i = m % 24;
        }
        if (i < 10) {
          g.append('0');
        }
        g.append(i);
        g.append(':');
        if (j < 10) {
          g.append('0');
        }
        g.append(j);
      }
      else if (!paramBoolean)
      {
        g.append(' ');
        if (m < 10) {
          g.append('0');
        }
        g.append(m);
        g.append(':');
        if (j < 10) {
          g.append('0');
        }
        g.append(j);
      }
    }
    else
    {
      localStringBuffer = g;
      localStringBuffer.append(f.get(1));
      localStringBuffer.append('/');
      localStringBuffer.append(f.get(2) + 1);
      localStringBuffer.append('/');
      localStringBuffer.append(f.get(5));
      if (!paramBoolean)
      {
        g.append(' ');
        g.append(m);
        g.append(':');
        if (j < 10) {
          g.append('0');
        }
        g.append(j);
      }
    }
    return g.toString();
  }
  
  private static int b(long paramLong)
  {
    long l = System.currentTimeMillis();
    int j = e;
    int i = (int)((l + j) / 86400000L);
    j = (int)((paramLong + j) / 86400000L);
    if (j == i) {
      return 2131917319;
    }
    if (j == i - 1) {
      return 2131918208;
    }
    if (j == i - 2) {
      return 2131887542;
    }
    return -1;
  }
  
  private void g()
  {
    super.setContentView(2131627874);
    setContentBackgroundResource(2130838958);
    this.d = ((XListView)findViewById(2131446715));
    this.b = b();
    if (this.b != null)
    {
      this.a = a();
      CursorAdapter localCursorAdapter = this.a;
      if (localCursorAdapter != null)
      {
        this.d.setAdapter(localCursorAdapter);
        this.d.setTranscriptMode(1);
        this.d.setSelection(0);
        this.app.getMessageFacade().addObserver(this);
        setTitle(c());
        e = TimeZone.getDefault().getRawOffset();
        return;
      }
      throw new Exception("mAdapter is null");
    }
    throw new Exception("peerUin is null");
  }
  
  protected long a(long paramLong)
  {
    if (this.c.containsKey(Long.valueOf(paramLong))) {
      return ((Long)this.c.get(Long.valueOf(paramLong))).longValue();
    }
    return -1L;
  }
  
  protected CursorAdapter a()
  {
    return null;
  }
  
  protected void a(Cursor paramCursor)
  {
    this.c.clear();
    if (paramCursor.moveToFirst())
    {
      Object localObject1 = null;
      do
      {
        long l1 = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
        long l2 = paramCursor.getLong(paramCursor.getColumnIndex("time"));
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
        }
        this.c.put(Long.valueOf(l1), Long.valueOf(l2));
        localObject1 = localObject2;
      } while (paramCursor.moveToNext());
    }
    paramCursor.moveToFirst();
  }
  
  protected String b()
  {
    return null;
  }
  
  protected CharSequence c()
  {
    return "";
  }
  
  protected Cursor d()
  {
    return null;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void e() {}
  
  protected void f()
  {
    if (d() != null)
    {
      a(d());
      this.a.changeCursor(d());
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      g();
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    this.rightViewText.setVisibility(0);
    this.rightViewText.setCompoundDrawablesWithIntrinsicBounds(2130853240, 0, 0, 0);
    return this.rightViewText;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.getMessageFacade().deleteObserver(this);
    CursorAdapter localCursorAdapter = this.a;
    if (localCursorAdapter != null) {
      localCursorAdapter.changeCursor(null);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.changeCursor(d());
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageRecord)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.b.equals(paramObservable.frienduin)) && (paramObservable.istroop == 0))
      {
        this.app.getMessageFacade().a(this.b, 0);
        runOnUiThread(new BaseSystemActivity.1(this));
      }
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new BaseSystemActivity.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseSystemActivity
 * JD-Core Version:    0.7.0.1
 */