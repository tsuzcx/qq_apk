package com.tencent.mobileqq.apollo.sdk;

import akji;
import akre;
import akxe;
import akxf;
import akxg;
import akxh;
import akxi;
import akxj;
import akxk;
import akxl;
import akye;
import alfz;
import alga;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import mqq.util.WeakReference;

public class CmShowRenderView
  extends ApolloTextureView
{
  private static int jdField_a_of_type_Int;
  private static final HashMap<String, WeakReference<CmShowRenderView>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static boolean jdField_a_of_type_Boolean;
  private akye jdField_a_of_type_Akye;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public CmShowRenderView(Context paramContext)
  {
    super(paramContext, null);
    if (!a(paramContext)) {
      throw new RuntimeException("isSdkInit is false!");
    }
    jdField_a_of_type_JavaUtilHashMap.put(toString(), new WeakReference(this));
  }
  
  public CmShowRenderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (!a(paramContext)) {
      throw new RuntimeException("isSdkInit is false!");
    }
    jdField_a_of_type_JavaUtilHashMap.put(toString(), new WeakReference(this));
  }
  
  public static void a(int paramInt, akxk paramakxk)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "changeApolloStatus mode:", Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("mode", paramInt);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_change_mode", localBundle, new akxi(paramakxk));
  }
  
  public static void a(alga paramalga, int paramInt)
  {
    if (paramalga == null)
    {
      QLog.e("CmShow_CmShowRenderView", 1, "initSdk cmSoLoadCompleteCallback == null");
      return;
    }
    jdField_a_of_type_Int = paramInt;
    akre.a();
    Bundle localBundle = new Bundle();
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_get_base_data", localBundle, new akxf(paramalga));
  }
  
  public static void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_open_store", localBundle, new akxh());
  }
  
  public static void a(String paramString1, String paramString2, akxl paramakxl, int paramInt)
  {
    if (paramakxl == null)
    {
      QLog.e("CmShow_CmShowRenderView", 1, "initSdk cmSoLoadCompleteCallback == null");
      return;
    }
    akre.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("selfUin", paramString1);
    localBundle.putString("friendUin", paramString2);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_init_cmshow_data", localBundle, new akxg(paramString1, paramString2, paramakxl));
  }
  
  public static void a(ArrayList<String> paramArrayList, int[] paramArrayOfInt)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "preLoadRes uins:", paramArrayList });
    akye.a(paramArrayList, paramArrayOfInt);
  }
  
  public static void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    QLog.i("CmShow_CmShowRenderView", 1, "onDressChanged uin.size:" + paramList.size());
    ThreadManagerV2.getUIHandlerV2().post(new CmShowRenderView.3(paramList));
  }
  
  public static boolean a(Context paramContext)
  {
    return (akji.b(paramContext)) && (alfz.a()) && (jdField_a_of_type_Boolean);
  }
  
  private void b(List<String> paramList)
  {
    Object localObject1 = null;
    if ((paramList == null) || (paramList.isEmpty())) {
      break label15;
    }
    label15:
    while (this.jdField_a_of_type_Akye == null) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    Object localObject2 = null;
    paramList = (List<String>)localObject1;
    label35:
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = localObject2;
        if (str.equals(this.jdField_a_of_type_JavaLangString)) {
          localObject1 = this.jdField_a_of_type_JavaLangString;
        }
      }
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.b))) {
        break label140;
      }
      paramList = this.b;
    }
    label140:
    for (;;)
    {
      localObject2 = localObject1;
      break label35;
      if ((TextUtils.isEmpty(localObject2)) && (!TextUtils.isEmpty(paramList))) {
        break;
      }
      this.jdField_a_of_type_Akye.a(localObject2, paramList);
      return;
    }
  }
  
  public int a(String paramString)
  {
    return akxe.a(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akye != null) {
      this.jdField_a_of_type_Akye.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!a(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "stopAction actionId:", Integer.valueOf(paramInt1), " actionSeqId:", Integer.valueOf(paramInt2) });
    } while (this.jdField_a_of_type_Akye == null);
    this.jdField_a_of_type_Akye.a(paramInt1, paramInt2);
  }
  
  public void a(akxj paramakxj, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Akye = new akye(this, paramInt);
    this.jdField_a_of_type_Akye.a(paramString1);
    this.jdField_a_of_type_Akye.a(paramakxj);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    if (!a(BaseApplicationImpl.getContext()))
    {
      QLog.e("CmShow_CmShowRenderView", 1, "playAction !isSdkInit");
      return;
    }
    if (paramPlayActionConfig == null)
    {
      QLog.e("CmShow_CmShowRenderView", 1, "playAction playActionConfig == null");
      return;
    }
    QLog.i("CmShow_CmShowRenderView", 1, "playAction before");
    this.jdField_a_of_type_Akye.a(paramPlayActionConfig);
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "playAction playActionConfig:", paramPlayActionConfig });
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "changeSpriteModel mode:", Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_Akye != null) {
      this.jdField_a_of_type_Akye.a(paramString, paramInt);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("CmShow_CmShowRenderView", 1, "updateAvatarParam");
    if (this.jdField_a_of_type_Akye != null) {
      this.jdField_a_of_type_Akye.a(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    if (!a(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "initAvatar !isSdkInit");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
      {
        QLog.e("CmShow_CmShowRenderView", 1, "initAvatar empty uin");
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
    } while (this.jdField_a_of_type_Akye == null);
    this.jdField_a_of_type_Akye.a(paramString1, paramString2, paramFloat, paramInt, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!a(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "showBubble uin:", ApolloUtil.d(paramString1), " bubbleText:", paramString2 });
    } while (this.jdField_a_of_type_Akye == null);
    this.jdField_a_of_type_Akye.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "hideAvatar uin", ApolloUtil.d(paramString), " show:", Boolean.valueOf(paramBoolean) });
    if (this.jdField_a_of_type_Akye != null) {
      this.jdField_a_of_type_Akye.a(paramString, paramBoolean);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    QLog.d("CmShow_CmShowRenderView", 1, "disposeAvatar");
    if (this.jdField_a_of_type_Akye != null) {
      this.jdField_a_of_type_Akye.a(paramList, paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Akye != null) {
      this.jdField_a_of_type_Akye.a();
    }
  }
  
  public void b(String paramString)
  {
    if (!a(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "showBubble uin:", ApolloUtil.d(paramString) });
    } while (this.jdField_a_of_type_Akye == null);
    this.jdField_a_of_type_Akye.b(paramString);
  }
  
  public void c()
  {
    QLog.d("CmShow_CmShowRenderView", 1, "onDestroy");
    if (this.jdField_a_of_type_Akye != null) {
      this.jdField_a_of_type_Akye.c();
    }
    jdField_a_of_type_JavaUtilHashMap.remove(toString());
  }
  
  public void setTouchEventRect(Rect paramRect1, Rect paramRect2, String paramString1, Rect paramRect3, String paramString2)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "setTouchEventRect leftRect:", paramRect2, " leftUin:", paramString1, " rightRect:", paramRect3, " rightUin:", paramString2 });
    ApolloRender localApolloRender = getRender();
    if (localApolloRender != null)
    {
      ApolloRender.setAABBCallBack(localApolloRender, paramRect2.left, paramRect1.bottom - paramRect2.bottom, paramRect2.right - paramRect2.left, paramRect2.bottom - paramRect2.top, paramString1, "", 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
      ApolloRender.setAABBCallBack(localApolloRender, paramRect3.left, paramRect1.bottom - paramRect3.bottom, paramRect3.right - paramRect3.left, paramRect3.bottom - paramRect3.top, paramString2, "", 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowRenderView
 * JD-Core Version:    0.7.0.1
 */