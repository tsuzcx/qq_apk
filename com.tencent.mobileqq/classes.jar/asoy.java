import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class asoy
  extends aspm
  implements Handler.Callback, View.OnClickListener
{
  protected asoz a;
  protected EmoticonPackage a;
  private MqqHandler a;
  protected boolean a;
  protected boolean b;
  private int f = 2;
  private int g;
  
  public asoy(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, asmr paramasmr, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr);
    this.jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    if (paramEmoticonPackage.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.g = paramInt4;
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (this.jdField_a_of_type_Asoz == null)) {}
    ProgressButton localProgressButton;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "doDownloadOpr epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        }
        localProgressButton = this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
      } while (localProgressButton == null);
      if (!paramBoolean) {
        break;
      }
      d();
    } while (this.f != 2);
    askd localaskd = (askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals("10278")))
    {
      ((anwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, this.g);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
    }
    localProgressButton.setProgressDrawable(localProgressButton.a(-16745986));
    float f1 = localaskd.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    int i;
    if (this.h == 2)
    {
      localProgressButton.setText(anzj.a(2131703019));
      localProgressButton.setProgress((int)f1);
      localaskd.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, true, this.g);
      this.h = 1;
      i = 1;
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, i + "", "");
      return;
      if (this.h == 1)
      {
        String str = anzj.a(2131703014);
        if (this.b) {
          str = anzj.a(2131703011);
        }
        localProgressButton.setText(str);
        localProgressButton.setProgress(0);
        this.h = 2;
        localaskd.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
        i = 2;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aspt != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Aspt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))
          {
            EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_Aspt.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) {
      return;
    }
    int i = ((aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 4)
    {
      if ((i == 1) || (i == 3))
      {
        this.f = 2;
        return;
      }
      this.f = 0;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5)
    {
      if (i == 3)
      {
        this.f = 2;
        return;
      }
      this.f = 1;
      return;
    }
    this.f = 2;
  }
  
  public View a(aslu paramaslu, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public aslu a()
  {
    return new asoz();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 18)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "payback");
      }
      if (a())
      {
        a(true);
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057AD", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
        }
      }
    }
  }
  
  public void a(asoz paramasoz)
  {
    if ((paramasoz == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "updateUI holder is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateUI epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    paramasoz.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
    paramasoz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = asfa.a(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    String str;
    for (;;)
    {
      try
      {
        localDrawable1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838010);
        localDrawable2 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843719);
        if (!bhmi.a((String)localObject)) {
          continue;
        }
        localObject = beyq.a(new URL("file:///" + (String)localObject), localDrawable1, localDrawable2);
        if (localObject == null) {
          continue;
        }
        paramasoz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Drawable localDrawable1;
        Drawable localDrawable2;
        float f1;
        paramasoz.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843719);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramasoz.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843719);
        continue;
        str = anzj.a(2131703018);
        if (!this.b) {
          break;
        }
      }
      paramasoz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      f1 = ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Ep id=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + ", progress=" + f1);
      }
      if (f1 >= 0.0F)
      {
        paramasoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
        paramasoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress((int)(f1 * 100.0F));
        paramasoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(anzj.a(2131703012));
        this.h = 1;
        paramasoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setOnClickListener(this);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = asfa.b(19, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          localObject = beyq.a((String)localObject, localDrawable1, localDrawable2);
        }
        else
        {
          localObject = asfa.b(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          continue;
          paramasoz.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843719);
        }
      }
      else
      {
        str = anzj.a(2131703015);
      }
    }
    for (;;)
    {
      paramasoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
      paramasoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
      paramasoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(str);
      this.h = 2;
      if (!a()) {
        break;
      }
      c();
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5))
      {
        d();
        if (this.f != 2) {
          str = anzj.a(2131703017);
        }
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
      {
        str = anzj.a(2131703013);
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt != 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.obj = paramEmoticonPackage;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "onAdapterSelected emotionpkg = null");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 4) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 5)) {
        break;
      }
      d();
    } while (this.f != 2);
    while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
    {
      askd localaskd = (askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      if ((localaskd.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId) >= 0.0F) || (!asos.b())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "wifi auto download emotion , epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      }
      localaskd.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, false, this.g);
      if ((this.jdField_a_of_type_Asoz != null) && (this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null))
      {
        this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
        this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(anzj.a(2131703016));
        this.h = 1;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
      return;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.b)
    {
      if (paramInt == 0) {
        return 0;
      }
      return 1;
    }
    return super.getItemViewType(paramInt);
  }
  
  public int getViewTypeCount()
  {
    if (this.b) {
      return 2;
    }
    return super.getViewTypeCount();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramMessage.obj;
    if ((this.jdField_a_of_type_Asoz == null) || (this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "packageDownloadEnd view is null");
    }
    do
    {
      do
      {
        do
        {
          return true;
        } while ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)) || (localEmoticonPackage == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId)));
        switch (paramMessage.what)
        {
        default: 
          return true;
        case 100: 
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage refreshCover epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          }
          paramMessage = asfa.a(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        }
      } while (paramMessage == null);
      this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
      return true;
      paramMessage = askd.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), localEmoticonPackage.epId);
    } while (paramMessage == null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage refreshprogress epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    int i = (int)paramMessage.a();
    this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(anzj.a(2131703009));
    this.h = 1;
    this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgressDrawable(this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.a(-16745986));
    this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(i);
    return true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage packageDownloadEnd epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    if (this.b) {
      this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(anzj.a(2131703010));
    }
    this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(anzj.a(2131703008));
    this.jdField_a_of_type_Asoz.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
    this.h = 2;
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131365250) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5))
      {
        d();
        if (this.f != 2)
        {
          Object localObject = "mvip.g.a.bq_" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
          String str = "!vip";
          if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5) {
            str = "!svip";
          }
          str = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + str + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", str);
          if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
            ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 4813);
          }
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
        }
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 4) {}
        for (boolean bool = true;; bool = false)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, bool);
          break;
        }
      }
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoy
 * JD-Core Version:    0.7.0.1
 */