package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ApolloViewBinder
{
  public SessionInfo a;
  public List a;
  public Context b;
  public int c = 0;
  public int d;
  public int e;
  protected int f = -1;
  
  public int a()
  {
    return 0;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public View a()
  {
    return null;
  }
  
  public View a(int paramInt)
  {
    View localView = a();
    a(localView, paramInt);
    return localView;
  }
  
  public ApolloInfo a(String paramString)
  {
    return null;
  }
  
  public ArrayList a(int paramInt)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(View paramView, int paramInt) {}
  
  public void a_(List paramList)
  {
    this.a = paramList;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] highlightItemIndex=", Integer.valueOf(paramInt) });
    }
    if ((this.a == null) || (this.a.size() == 0)) {
      QLog.e("ApolloViewBinder", 1, "[setHighlightItemIndex] no panel data, set failed");
    }
    do
    {
      do
      {
        return;
      } while ((paramInt < 0) || (paramInt >= this.a.size()));
      this.f = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] set success, highlightItemIndex=", Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloViewBinder
 * JD-Core Version:    0.7.0.1
 */