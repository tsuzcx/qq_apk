import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class awwo
  extends awul
{
  public static int k;
  public static int l;
  public static int m = 3;
  public String S;
  public String T;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public int i;
  public int j;
  public int n = m;
  
  static
  {
    jdField_k_of_type_Int = 1;
    jdField_l_of_type_Int = 2;
  }
  
  public awwo()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new awwp(this);
    this.jdField_a_of_type_JavaLangString = "picture";
    this.jdField_a_of_type_Int = 15;
  }
  
  public awwo(String paramString)
  {
    this();
    this.S = paramString;
  }
  
  public awwo(String paramString1, String paramString2)
  {
    this();
    this.S = paramString1;
    this.T = paramString2;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    try
    {
      int i1 = paramDrawable.getIntrinsicWidth();
      if (paramDrawable.getOpacity() != -1) {}
      for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
      {
        localObject = Bitmap.createBitmap(i1, i1, (Bitmap.Config)localObject);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, i1, i1);
        paramDrawable.draw(localCanvas);
        paramDrawable = bacm.a((Bitmap)localObject, i1, i1, i1);
        ((Bitmap)localObject).recycle();
        return paramDrawable;
      }
      return null;
    }
    catch (Exception paramDrawable)
    {
      return null;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      QLog.e("StructMsgItemCover", 2, "getRoundedCornerBitmap  OutOfMemoryError");
    }
  }
  
  private URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    try
    {
      Object localObject1 = new URL(paramString);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramDrawable1;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = paramBoolean1;
      ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
      ((URLDrawable.URLDrawableOptions)localObject2).mNeedCheckNetType = paramBoolean2;
      ((URLDrawable.URLDrawableOptions)localObject2).mRetryCount = 3;
      ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = paramObject;
      paramString = new axrk();
      paramString.jdField_a_of_type_Int = 1001;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        paramString.b = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID;
        paramString.c = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgTemplateID;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
          paramString.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.istroop);
        }
      }
      ((URLDrawable.URLDrawableOptions)localObject2).mHttpDownloaderParams = paramString;
      localObject2 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      if ("url.cn".equals(((URL)localObject1).getHost()))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramDrawable1;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramDrawable2;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = paramBoolean1;
        ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = 0.0F;
        ((URLDrawable.URLDrawableOptions)localObject1).mNeedCheckNetType = paramBoolean2;
        ((URLDrawable.URLDrawableOptions)localObject1).mRetryCount = 3;
        ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = paramObject;
        ((URLDrawable.URLDrawableOptions)localObject1).mHttpDownloaderParams = paramString;
        ((URLDrawable)localObject2).setTag(localObject1);
      }
      return localObject2;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, false, paramBundle);
  }
  
  public View a(Context paramContext, View paramView, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "StructMsgItemCover createView start! mUrlString = " + this.S);
    }
    boolean bool2;
    if (paramBundle != null) {
      bool2 = paramBundle.getBoolean("pre_dialog");
    }
    boolean bool1;
    Object localObject3;
    int i1;
    Object localObject1;
    Object localObject2;
    Drawable localDrawable2;
    for (;;)
    {
      if (paramBundle == null) {
        break label2028;
      }
      bool1 = paramBundle.getBoolean("pa_should_change");
      localObject3 = paramContext.getResources();
      i1 = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      try
      {
        Drawable localDrawable1 = nfa.a().a((Resources)localObject3, 2130849109);
        if ((paramView != null) && ((paramView instanceof PAImageView)))
        {
          localObject1 = (PAHighLightImageView)paramView;
          localObject2 = paramView;
          ((PAHighLightImageView)localObject1).setTag(this);
          paramView = this.S;
          if ((TextUtils.isEmpty(paramView)) && (paramBundle != null) && (paramBundle.containsKey("extend-data-json")) && (paramBundle.getInt("serviceID", 0) == 128))
          {
            paramBundle = paramBundle.getString("extend-data-json");
            if (TextUtils.isEmpty(paramBundle)) {}
          }
        }
        else
        {
          try
          {
            if (!(paramContext instanceof BaseActivity)) {
              break label317;
            }
            paramBundle = new JSONObject(paramBundle);
            ((PAHighLightImageView)localObject1).setImageDrawable(azwp.a(((BaseActivity)paramContext).app, 4, paramBundle.optString("groupcode")));
            ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
            return localObject2;
          }
          catch (Throwable paramContext)
          {
            QLog.d("StructMsgItemCover", 1, "createView error:" + paramContext.getMessage());
          }
          bool2 = false;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localDrawable2 = null;
          continue;
          localObject2 = new FixRatioPAHighLightImageView(paramContext);
          ((PAHighLightImageView)localObject2).setId(2131302327);
          ((PAHighLightImageView)localObject2).setContentDescription(((Resources)localObject3).getString(2131625662));
          localObject1 = localObject2;
        }
      }
    }
    label317:
    if (TextUtils.isEmpty(paramView))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "StructMsgItemCover createView ,url = " + paramView);
      }
      ((PAHighLightImageView)localObject1).setImageDrawable(localDrawable2);
      ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (bool1) {
        ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe2"));
      }
      for (;;)
      {
        if ((this.c != null) && (!this.c.equals("")))
        {
          ((View)localObject2).setClickable(true);
          ((View)localObject2).setOnClickListener(this);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("[@]", 2, "StructMsgItemCover createView end!");
        return localObject2;
        ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe4"));
      }
    }
    label387:
    label552:
    label632:
    label2045:
    for (;;)
    {
      int i2;
      try
      {
        if ((paramView.startsWith("http://")) || (paramView.startsWith("https://"))) {
          break label1230;
        }
        boolean bool3 = paramView.startsWith("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2));
        if (bool3) {
          break label1230;
        }
        try
        {
          if (!paramView.startsWith("mqqapi://card")) {
            break label1111;
          }
          i1 = paramView.lastIndexOf("&uin=");
          if (i1 != -1) {
            break label758;
          }
          if (QLog.isColorLevel()) {
            QLog.e("StructMsgItemCover", 2, "createView, error: index is -1");
          }
          ((PAHighLightImageView)localObject1).setImageDrawable(bacm.a());
          return localObject2;
        }
        catch (MalformedURLException paramContext)
        {
          i1 = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.e("StructMsgItemCover", 2, "createView, error: " + paramContext.getMessage());
        }
        ((PAHighLightImageView)localObject1).setImageDrawable(bacm.a());
        paramContext = null;
        if ((paramContext == null) || (paramContext.getStatus() != 1)) {
          break label1957;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set null");
        }
        ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (paramBoolean) {
          ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
        }
        if ((paramContext == null) || (!paramBoolean)) {
          break label1984;
        }
        i2 = i1;
        if (i1 == 0) {
          i2 = paramContext.getIntrinsicWidth();
        }
        paramContext.setTag(azue.b(i2, i2, i2));
        paramContext.setDecodeHandler(azue.i);
        ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
        if (paramContext.getStatus() == 1) {
          break label387;
        }
        paramContext.restartDownload();
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label748;
        }
      }
      if ("StructMsgItemCover createView ,exception  = " + paramContext != null)
      {
        paramContext = paramContext.getMessage();
        QLog.d("StructMsgItemCover", 2, paramContext);
        ((PAHighLightImageView)localObject1).setImageDrawable(localDrawable2);
        break label387;
        paramContext = paramView.substring("&uin=".length() + i1);
        i1 = paramContext.lastIndexOf("&");
        paramBundle = paramContext;
        if (i1 != -1) {
          paramBundle = paramContext.substring(0, i1);
        }
        if (localObject2 != null)
        {
          localObject3 = ((View)localObject2).getContext();
          if ((localObject3 instanceof BaseActivity))
          {
            ((PAHighLightImageView)localObject1).e = "";
            QQAppInterface localQQAppInterface = ((BaseActivity)localObject3).app;
            paramContext = bacm.a();
            if (paramView.indexOf("internal_phone") > -1)
            {
              i1 = paramView.indexOf("&headtext=");
              paramContext = "";
              if (i1 != -1)
              {
                i2 = paramView.indexOf("&", i1 + 1);
                if (i2 == -1) {
                  paramContext = paramView.substring("&headtext=".length() + i1);
                }
              }
              else
              {
                paramContext = URLDecoder.decode(paramContext);
                if (TextUtils.isEmpty(paramContext.trim())) {
                  break label1052;
                }
                if (!bool2) {
                  break label1013;
                }
                if (!babh.a(paramContext)) {
                  break label997;
                }
                i1 = ((Context)localObject3).getResources().getDimensionPixelSize(2131167731);
                ((PAHighLightImageView)localObject1).setTextSize(i1);
                ((PAHighLightImageView)localObject1).e = paramContext;
                paramContext = ((Context)localObject3).getResources().getDrawable(2130841491);
              }
            }
            for (;;)
            {
              ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
              return localObject2;
              paramContext = paramView.substring(i1 + "&headtext=".length(), i2);
              break;
              i1 = ((Context)localObject3).getResources().getDimensionPixelSize(2131167733);
              break label944;
              if (babh.a(paramContext))
              {
                i1 = ((Context)localObject3).getResources().getDimensionPixelSize(2131167727);
                break label944;
              }
              i1 = ((Context)localObject3).getResources().getDimensionPixelSize(2131167729);
              break label944;
              if (paramBundle.startsWith("+"))
              {
                paramContext = azwp.b(localQQAppInterface, paramBundle, (byte)3);
              }
              else
              {
                paramContext = azwp.a(11, 3);
                continue;
                paramContext = azwp.a(localQQAppInterface, 1, paramBundle, 3, paramContext, paramContext);
              }
            }
          }
        }
        ((PAHighLightImageView)localObject1).setImageDrawable(bacm.a());
        return localObject2;
        if (paramView.startsWith("troop_notice"))
        {
          ((PAHighLightImageView)localObject1).setImageResource(2130843173);
          return localObject2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,begin decode");
        }
        paramContext = new File(paramView).toURL().toString();
        for (;;)
        {
          for (;;)
          {
            try
            {
              if (this.n == jdField_k_of_type_Int)
              {
                i2 = aciy.a(70.0F, (Resources)localObject3);
                i1 = i2;
              }
            }
            catch (MalformedURLException paramContext) {}
            try
            {
              paramContext = URLDrawable.getDrawable(paramContext, i1, i1, localDrawable2, localDrawable2, true);
            }
            catch (MalformedURLException paramContext) {}
          }
          if (this.n != jdField_l_of_type_Int) {
            break label2025;
          }
          i2 = aciy.a(140.0F, (Resources)localObject3);
          i1 = i2;
          continue;
          paramBundle = null;
          if (paramView.startsWith("http://p.qlogo.cn/gh/"))
          {
            i2 = paramView.lastIndexOf("gh/");
            paramContext = paramView.substring("gh/".length() + i2).split("/")[0];
            if (TextUtils.isEmpty(paramContext)) {
              break label2034;
            }
            paramView = ((View)localObject2).getContext();
            if ((paramView instanceof BaseActivity))
            {
              paramView = ((BaseActivity)paramView).app;
              paramBundle = azwp.a(4, 3);
              ((PAHighLightImageView)localObject1).setImageDrawable(azwp.a(paramView, 4, paramContext, 3, paramBundle, paramBundle));
              return localObject2;
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(bacm.a());
            return localObject2;
          }
        }
      }
      for (;;)
      {
        if (this.n == jdField_k_of_type_Int)
        {
          ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
          i1 = aciy.a(70.0F, (Resources)localObject3);
          if (!bool1) {
            break label1943;
          }
          ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe2"));
        }
        for (;;)
        {
          paramContext = a(paramContext, i1, i1, localDrawable2, localDrawable2, true, true, paramView);
          if (paramContext.getTag() == null) {
            paramContext.setTag(Integer.valueOf(0));
          }
          paramContext.setAutoDownload(true);
          if (paramContext.getStatus() != 2) {
            break label2045;
          }
          paramContext.restartDownload();
          break label2045;
          if ((paramView.startsWith(wmi.b)) || (paramView.startsWith(wmi.c)) || (paramView.startsWith(wmi.d)))
          {
            ((PAHighLightImageView)localObject1).setBackgroundDrawable(null);
            i1 = paramView.lastIndexOf("&uin=");
            paramContext = paramView.substring("&uin=".length() + i1);
            paramView = ((View)localObject2).getContext();
            if ((paramView instanceof BaseActivity))
            {
              ((PAHighLightImageView)localObject1).setImageDrawable(((BaseActivity)paramView).app.a(paramContext, false, (byte)4));
              return localObject2;
            }
            ((PAHighLightImageView)localObject1).setImageDrawable(bacm.a());
            return localObject2;
          }
          if (paramView.startsWith("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2)))
          {
            paramContext = new ColorDrawable(0);
            ((PAHighLightImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramView, paramContext, paramContext));
            return localObject2;
          }
          if ((paramView.startsWith("http://imgplat.store.qq.com/bqq_qfpic/520520")) || (paramView.contains(wfz.jdField_a_of_type_JavaLangString)))
          {
            paramBoolean = true;
            this.jdField_a_of_type_Boolean = true;
            paramBundle = null;
            paramContext = paramView;
            paramView = paramBundle;
            break;
          }
          if ((this.T != null) && (this.T.equals("1")))
          {
            paramBoolean = true;
            this.jdField_a_of_type_Boolean = true;
            paramBundle = null;
            paramContext = paramView;
            paramView = paramBundle;
            break;
          }
          bool2 = paramView.startsWith("http://qqpublic.qpic.cn");
          if (bool2)
          {
            for (;;)
            {
              for (;;)
              {
                try
                {
                  if (new URL(paramView).getQuery() != null)
                  {
                    paramContext = "&spec=screen";
                    if (this.n == jdField_k_of_type_Int)
                    {
                      paramContext = "&spec=small";
                      new String(paramView);
                      paramContext = paramView + paramContext;
                      paramView = paramBundle;
                    }
                  }
                }
                catch (MalformedURLException paramContext) {}
                try
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
                  {
                    paramView = paramBundle;
                    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
                      paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
                    }
                  }
                }
                catch (MalformedURLException paramView)
                {
                  for (;;)
                  {
                    paramView = paramContext;
                  }
                }
              }
              if (this.n == jdField_l_of_type_Int)
              {
                paramContext = "&spec=middle";
                continue;
                paramContext = "?spec=screen";
                if (this.n == jdField_k_of_type_Int) {
                  paramContext = "?spec=small";
                } else if (this.n == jdField_l_of_type_Int) {
                  paramContext = "?spec=middle";
                }
              }
            }
            throw new IllegalArgumentException("illegal url format: " + paramView);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.istroop != 1008)) {
            break label2014;
          }
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
          paramContext = paramView;
          paramView = paramBundle;
          break;
          if (this.n == jdField_l_of_type_Int)
          {
            ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
            i1 = aciy.a(140.0F, (Resources)localObject3);
            break label1367;
          }
          ((PAHighLightImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
          break label1367;
          ((PAHighLightImageView)localObject1).setBackgroundColor(Color.parseColor("#dddfe4"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set listener");
        }
        ((PAHighLightImageView)localObject1).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        break label632;
        ((PAHighLightImageView)localObject1).setImageDrawable(paramContext);
        break label387;
        paramContext = " happens error ";
        break label741;
        break label552;
        break label552;
        paramBundle = null;
        paramContext = paramView;
        paramView = paramBundle;
        continue;
        break label1186;
        bool1 = false;
        break;
        paramBundle = null;
        paramContext = paramView;
        paramView = paramBundle;
      }
    }
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131310787) {
        return (StructMsgForGeneralShare)paramView.getTag(2131310787);
      }
    }
    return null;
  }
  
  public String a()
  {
    return "Cover";
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = aciy.a(paramView);
      localObject1 = localObject2;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject2;
      label13:
      Object localObject3;
      break label13;
    }
    if (localObject1 == null) {}
    do
    {
      return;
      localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
    } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (!this.S.endsWith("gif")));
    localObject1 = "0";
    localObject2 = ((FragmentActivity)paramView.getContext()).getChatFragment();
    if (localObject2 == null) {}
    for (localObject2 = null;; localObject2 = ((ChatFragment)localObject2).a())
    {
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        if (((JSONObject)localObject3).has("ad_id")) {
          localObject1 = ((JSONObject)localObject3).getString("ad_id");
        }
      }
      catch (Exception localException)
      {
        String str;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsgItemCover", 2, "parse ad_id error");
          }
          str = "0";
        }
        awqx.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, str, String.valueOf(paramView.msgId), "1", "");
        return;
      }
      paramView = a(paramView);
      if (paramView != null) {
        break label168;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StructMsgItemCover", 2, "StructMsgForGeneralShare == NULL");
      return;
    }
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentCover = this.S;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.S = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int <= 3) {}
    do
    {
      do
      {
        return;
        this.c = paramObjectInput.readUTF();
        this.b = paramObjectInput.readUTF();
      } while (this.jdField_a_of_type_Int <= 5);
      this.jdField_j_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_k_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_l_of_type_JavaLangString = paramObjectInput.readUTF();
      this.i = paramObjectInput.readInt();
      this.jdField_j_of_type_Int = paramObjectInput.readInt();
    } while (this.jdField_a_of_type_Int <= 8);
    this.T = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.S == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_a_of_type_Int > 3) {
        break label40;
      }
    }
    label40:
    label69:
    label95:
    label113:
    do
    {
      do
      {
        return;
        str = this.S;
        break;
        if (this.c != null) {
          break label186;
        }
        str = "";
        paramObjectOutput.writeUTF(str);
        if (this.b != null) {
          break label194;
        }
        str = "";
        paramObjectOutput.writeUTF(str);
      } while (this.jdField_a_of_type_Int <= 5);
      if (this.jdField_j_of_type_JavaLangString != null) {
        break label202;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_k_of_type_JavaLangString != null) {
        break label210;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_l_of_type_JavaLangString != null) {
        break label218;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.i);
      paramObjectOutput.writeInt(this.jdField_j_of_type_Int);
    } while (this.jdField_a_of_type_Int <= 8);
    label131:
    if (this.T == null) {}
    for (String str = "";; str = this.T)
    {
      paramObjectOutput.writeUTF(str);
      return;
      label186:
      str = this.c;
      break;
      label194:
      str = this.b;
      break label69;
      label202:
      str = this.jdField_j_of_type_JavaLangString;
      break label95;
      label210:
      str = this.jdField_k_of_type_JavaLangString;
      break label113;
      label218:
      str = this.jdField_l_of_type_JavaLangString;
      break label131;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.S == null) {}
    for (String str = "";; str = this.S)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      if (this.jdField_a_of_type_Int > 3)
      {
        if (!TextUtils.isEmpty(this.c)) {
          paramXmlSerializer.attribute(null, "action", this.c);
        }
        if (!TextUtils.isEmpty(this.b)) {
          paramXmlSerializer.attribute(null, "url", this.b);
        }
        if (this.jdField_a_of_type_Int > 5)
        {
          if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
            paramXmlSerializer.attribute(null, "index", this.jdField_j_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
            paramXmlSerializer.attribute(null, "index_name", this.jdField_k_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
            paramXmlSerializer.attribute(null, "index_type", this.jdField_l_of_type_JavaLangString);
          }
          paramXmlSerializer.attribute(null, "w", String.valueOf(this.i));
          paramXmlSerializer.attribute(null, "h", String.valueOf(this.jdField_j_of_type_Int));
          if ((this.jdField_a_of_type_Int > 8) && (!TextUtils.isEmpty(this.T))) {
            paramXmlSerializer.attribute(null, "needRoundView", this.T);
          }
        }
      }
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
  
  public boolean a(awwc paramawwc)
  {
    if (paramawwc == null) {}
    String str;
    label18:
    do
    {
      do
      {
        return true;
        str = paramawwc.a("cover");
        if (str == null) {
          break;
        }
        this.S = str;
      } while (this.jdField_a_of_type_Int <= 3);
      this.c = paramawwc.a("action");
      this.b = paramawwc.a("url");
    } while (this.jdField_a_of_type_Int <= 5);
    this.jdField_j_of_type_JavaLangString = paramawwc.a("index");
    this.jdField_k_of_type_JavaLangString = paramawwc.a("index_name");
    this.jdField_l_of_type_JavaLangString = paramawwc.a("index_type");
    for (;;)
    {
      try
      {
        str = paramawwc.a("w");
        if (str != null) {
          continue;
        }
        i1 = 0;
        this.i = i1;
        str = paramawwc.a("h");
        if (str != null) {
          continue;
        }
        i1 = 0;
        this.jdField_j_of_type_Int = i1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i1;
        this.i = 0;
        this.jdField_j_of_type_Int = 0;
        continue;
      }
      if (this.jdField_a_of_type_Int <= 8) {
        break;
      }
      this.T = paramawwc.a("needRoundView");
      return true;
      str = "";
      break label18;
      i1 = Integer.parseInt(str);
      continue;
      i1 = Integer.parseInt(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awwo
 * JD-Core Version:    0.7.0.1
 */