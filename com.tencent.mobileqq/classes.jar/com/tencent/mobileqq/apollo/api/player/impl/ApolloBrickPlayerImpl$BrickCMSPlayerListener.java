package com.tencent.mobileqq.apollo.api.player.impl;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloBrickPlayerImpl$BrickCMSPlayerListener
  implements ICMSPlayerListener
{
  private int jdField_a_of_type_Int;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private WeakReference<ImageView> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_b_of_type_Boolean = true;
  private WeakReference<RelativeLayout> c;
  private WeakReference<Handler> d;
  private WeakReference<Map<String, URLDrawable.URLDrawableOptions>> e;
  private WeakReference<IGetGifFrameCallback> f;
  
  public ApolloBrickPlayerImpl$BrickCMSPlayerListener(int paramInt1, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, int paramInt2, Handler paramHandler, Map<String, URLDrawable.URLDrawableOptions> paramMap, IGetGifFrameCallback paramIGetGifFrameCallback)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView1);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView2);
    this.c = new WeakReference(paramRelativeLayout);
    this.d = new WeakReference(paramHandler);
    this.e = new WeakReference(paramMap);
    this.f = new WeakReference(paramIGetGifFrameCallback);
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  /* Error */
  private Drawable a(boolean paramBoolean, CMSAction paramCMSAction, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: aconst_null
    //   2: aconst_null
    //   3: invokevirtual 62	com/tencent/mobileqq/apollo/api/player/action/CMSAction:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 4
    //   8: iload_1
    //   9: ifeq +151 -> 160
    //   12: invokestatic 68	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl:access$100	()Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload 4
    //   17: aload_3
    //   18: invokevirtual 74	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: invokestatic 79	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloAvatarFileManager:a	()Lcom/tencent/mobileqq/apollo/api/uitls/impl/ApolloAvatarFileManager;
    //   25: aload_0
    //   26: getfield 31	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:jdField_a_of_type_Int	I
    //   29: aload_3
    //   30: invokevirtual 82	com/tencent/mobileqq/apollo/api/uitls/impl/ApolloAvatarFileManager:a	(ILjava/lang/String;)V
    //   33: aload_2
    //   34: invokevirtual 85	com/tencent/mobileqq/apollo/api/player/action/CMSAction:a	()Lcom/tencent/mobileqq/apollo/api/player/action/MODE;
    //   37: getstatic 91	com/tencent/mobileqq/apollo/api/player/action/MODE:ACTION_MODE_RECORD_GIF	Lcom/tencent/mobileqq/apollo/api/player/action/MODE;
    //   40: if_acmpne +104 -> 144
    //   43: aload_3
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 46	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:e	Ljava/lang/ref/WeakReference;
    //   49: invokespecial 94	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:a	(Ljava/lang/ref/WeakReference;)Ljava/lang/Object;
    //   52: checkcast 96	java/util/Map
    //   55: aload_0
    //   56: getfield 50	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:jdField_b_of_type_Int	I
    //   59: i2f
    //   60: invokestatic 100	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl:access$400	(Ljava/lang/String;Ljava/util/Map;F)Lcom/tencent/image/URLDrawable;
    //   63: astore 4
    //   65: aload_0
    //   66: getfield 48	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:f	Ljava/lang/ref/WeakReference;
    //   69: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   72: ifnull +21 -> 93
    //   75: aload_0
    //   76: getfield 48	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:f	Ljava/lang/ref/WeakReference;
    //   79: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   82: checkcast 106	com/tencent/mobileqq/apollo/player/IGetGifFrameCallback
    //   85: iload_1
    //   86: aload_3
    //   87: aload_2
    //   88: invokeinterface 109 4 0
    //   93: invokestatic 115	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   96: ldc 117
    //   98: iconst_0
    //   99: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   102: invokeinterface 127 1 0
    //   107: new 129	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   114: ldc 132
    //   116: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: getfield 31	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:jdField_a_of_type_Int	I
    //   123: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload_3
    //   130: invokeinterface 149 3 0
    //   135: invokeinterface 153 1 0
    //   140: pop
    //   141: aload 4
    //   143: areturn
    //   144: aload_3
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 46	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:e	Ljava/lang/ref/WeakReference;
    //   150: invokespecial 94	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl$BrickCMSPlayerListener:a	(Ljava/lang/ref/WeakReference;)Ljava/lang/Object;
    //   153: checkcast 96	java/util/Map
    //   156: invokestatic 157	com/tencent/mobileqq/apollo/api/player/impl/ApolloBrickPlayerImpl:access$600	(Ljava/lang/String;Ljava/util/Map;)Lcom/tencent/image/URLDrawable;
    //   159: areturn
    //   160: invokestatic 163	com/tencent/mobileqq/transfile/URLDrawableHelper:getFailedDrawable	()Landroid/graphics/drawable/Drawable;
    //   163: astore_2
    //   164: aload_2
    //   165: areturn
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: ldc 165
    //   171: iconst_1
    //   172: ldc 167
    //   174: aload_3
    //   175: invokestatic 172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   178: aload_2
    //   179: areturn
    //   180: astore_3
    //   181: aload 4
    //   183: astore_2
    //   184: goto -15 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	BrickCMSPlayerListener
    //   0	187	1	paramBoolean	boolean
    //   0	187	2	paramCMSAction	CMSAction
    //   0	187	3	paramString	String
    //   6	176	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	65	166	java/lang/Exception
    //   144	160	166	java/lang/Exception
    //   160	164	166	java/lang/Exception
    //   65	93	180	java/lang/Exception
    //   93	141	180	java/lang/Exception
  }
  
  private URLDrawable.URLDrawableListener a(String paramString)
  {
    return new ApolloBrickPlayerImpl.BrickCMSPlayerListener.3(this, paramString);
  }
  
  private <T> T a(WeakReference<T> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      return paramWeakReference.get();
    }
    return null;
  }
  
  private void a(@NotNull CMSAction paramCMSAction, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
  {
    ImageView localImageView = (ImageView)a(this.jdField_b_of_type_JavaLangRefWeakReference);
    String str;
    Object localObject2;
    if ((localImageView != null) && (localImageView.getVisibility() == 0))
    {
      str = paramCMSAction.a(null, null);
      localObject2 = (ApolloRepeatPngDrawable)localImageView.getTag();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ApolloRepeatPngDrawable(str, paramInt1);
        localImageView.setTag(localObject1);
      }
      localObject2 = localObject1;
      if (!str.equals(((ApolloRepeatPngDrawable)localObject1).a()))
      {
        ((ApolloRepeatPngDrawable)localObject1).a();
        localObject2 = new ApolloRepeatPngDrawable(str, paramInt1);
        localImageView.setTag(localObject2);
        QLog.w("ApolloBrickPlayer", 1, "showFrameOnPreImageView create new pngDrawable:" + localObject2 + " for preview:" + a(this.jdField_b_of_type_JavaLangRefWeakReference) + ", actionKey:" + str);
      }
      if ((((ApolloRepeatPngDrawable)localObject2).a() != -1) || (((ApolloRepeatPngDrawable)localObject2).b() != 0) || (paramInt2 <= 0)) {
        break label352;
      }
      QLog.w("ApolloBrickPlayer", 1, "showFrameOnPreImageView " + localObject2 + " correct index from " + paramInt2 + " to " + 0);
    }
    label352:
    for (int i = 0;; i = paramInt2)
    {
      if (((ApolloRepeatPngDrawable)localObject2).a(i)) {
        QLog.e("ApolloBrickPlayer", 1, "showFrameOnPreImageView " + localObject2 + " already contain " + i);
      }
      do
      {
        do
        {
          return;
          ((ApolloRepeatPngDrawable)localObject2).a(i, paramArrayOfByte, paramInt3, paramInt4, paramInt1);
        } while (!this.jdField_b_of_type_Boolean);
        this.jdField_b_of_type_Boolean = false;
        localImageView.setLayoutParams(new RelativeLayout.LayoutParams(paramInt3, paramInt4));
        localImageView.setImageDrawable((Drawable)localObject2);
      } while (paramInt2 != 0);
      TraceReportUtil.a(paramCMSAction.a().toReportFeatureId(), str, 5, 0, new Object[0]);
      return;
    }
  }
  
  private void a(CMSAction paramCMSAction, Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      QLog.w("ApolloBrickPlayer", 1, "refreshViewOnRecordDone, but drawable is null");
      return;
    }
    a(new ApolloBrickPlayerImpl.BrickCMSPlayerListener.2(this, paramCMSAction.d(), paramDrawable, paramCMSAction.a(null, null)));
  }
  
  private void a(Runnable paramRunnable)
  {
    Handler localHandler = (Handler)a(this.d);
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private void b()
  {
    ImageView localImageView = (ImageView)a(this.jdField_b_of_type_JavaLangRefWeakReference);
    if (localImageView != null)
    {
      localImageView.setVisibility(8);
      ApolloRepeatPngDrawable localApolloRepeatPngDrawable = (ApolloRepeatPngDrawable)localImageView.getTag();
      if (localApolloRepeatPngDrawable != null)
      {
        localApolloRepeatPngDrawable.a();
        localImageView.setTag(null);
      }
    }
  }
  
  public void a()
  {
    QLog.e("ApolloBrickPlayer", 1, this + " destroy. mActionId:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
  }
  
  public void a(@NotNull CMSAction paramCMSAction) {}
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {}
    String str;
    label101:
    do
    {
      for (;;)
      {
        return;
        if (CmShowWnsUtils.o())
        {
          if (paramCMSAction.a() == MODE.ACTION_MODE_RECORD_GIF) {}
          for (int i = 1; i == 0; i = 0)
          {
            str = paramCMSAction.a(null, null);
            if (this.jdField_a_of_type_Int == paramCMSAction.d()) {
              break label101;
            }
            QLog.w("ApolloBrickPlayer", 2, this + " onRecordFrame return, mActionId " + this.jdField_a_of_type_Int + ", actionKey:" + str);
            return;
          }
        }
      }
    } while ((Handler)a(this.d) == null);
    ThreadManager.excute(new ApolloBrickPlayerImpl.BrickCMSPlayerListener.1(this, paramArrayOfByte, str, paramInt1, paramInt2, paramInt3, paramInt4, paramCMSAction), 128, null, false);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus) {}
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ApolloBrickPlayer", 2, "onRecordDone " + paramBoolean + " mActionId " + this.jdField_a_of_type_Int + " " + paramString2);
      }
      a(paramCMSAction, a(paramBoolean, paramCMSAction, paramString2));
      paramCMSAction = paramCMSAction.a(null, null);
    } while (!ApolloBrickPlayerImpl.access$1400().containsKey(paramCMSAction));
    ApolloBrickPlayerImpl.access$1400().remove(paramCMSAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloBrickPlayerImpl.BrickCMSPlayerListener
 * JD-Core Version:    0.7.0.1
 */