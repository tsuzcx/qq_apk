package com.tencent.mobileqq.apollo.view;

import ajrs;
import ajrt;
import ajyc;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import bcpw;
import bfol;
import bfoq;
import bgyu;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;

public class ShareImageHandler
  implements ajrt, DialogInterface.OnDismissListener, Handler.Callback, AdapterView.OnItemClickListener, bfoq
{
  private long jdField_a_of_type_Long;
  private ajrs jdField_a_of_type_Ajrs;
  private bfol jdField_a_of_type_Bfol;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<Activity> b;
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Bfol != null) {
      this.jdField_a_of_type_Bfol.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            AppInterface localAppInterface;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return false;
                    } while (this.jdField_a_of_type_Boolean);
                    paramMessage = (String)paramMessage.obj;
                  } while ((TextUtils.isEmpty(paramMessage)) || (this.b == null) || (this.b.get() == null));
                  bcpw.a((Context)this.b.get(), ajyc.a(2131713945) + paramMessage, 1).a();
                  return false;
                  if (this.jdField_a_of_type_Bfol != null) {
                    this.jdField_a_of_type_Bfol.dismiss();
                  }
                } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.b == null) || (this.b.get() == null));
                localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
              } while (localAppInterface == null);
              paramMessage = (String)paramMessage.obj;
              if (!TextUtils.isEmpty(paramMessage)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("ShareImageHandler", 1, "onItemClick share QZone apolloImage no file");
            return false;
            Bundle localBundle = new Bundle();
            ArrayList localArrayList = new ArrayList();
            try
            {
              localArrayList.add(URLDecoder.decode(paramMessage));
              localBundle.putStringArrayList("images", localArrayList);
              localBundle.putString("summary", ajyc.a(2131713944));
              localBundle.putInt("req_type", 7);
              localBundle.putBoolean("key_need_save_draft", false);
              bgyu.a(localAppInterface, (Context)this.b.get(), localBundle, this, 15);
              return false;
            }
            catch (Exception paramMessage)
            {
              QLog.d("ShareImageHandler", 2, "publishToQzone:" + paramMessage.getMessage());
              return false;
            }
            if (this.jdField_a_of_type_Bfol != null) {
              this.jdField_a_of_type_Bfol.dismiss();
            }
          } while (this.jdField_a_of_type_Boolean);
          paramMessage = (String)paramMessage.obj;
          if (!TextUtils.isEmpty(paramMessage)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ShareImageHandler", 1, "onItemClick share QQ apolloImage no file");
        return false;
        if (new File(paramMessage).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ShareImageHandler", 1, "onItemClick share QQ apolloImage no file");
      return false;
    } while ((this.b == null) || (this.b.get() == null));
    ApolloUtil.a((Activity)this.b.get(), paramMessage, null, 1);
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  @TargetApi(14)
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = l;
        if (paramLong != 1L) {
          break;
        }
      } while (this.jdField_a_of_type_Ajrs == null);
      this.jdField_a_of_type_Ajrs.a(this, 16);
      return;
    } while (this.jdField_a_of_type_Ajrs == null);
    this.jdField_a_of_type_Ajrs.a(this, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ShareImageHandler
 * JD-Core Version:    0.7.0.1
 */