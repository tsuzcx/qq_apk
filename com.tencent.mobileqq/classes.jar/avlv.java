import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class avlv
{
  private static long jdField_a_of_type_Long;
  private static View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avlw();
  private static Map<Object, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private static int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    paramString = a(paramString, "", paramMessageRecord);
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return paramInt;
  }
  
  public static TextView a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    paramRelativeLayout.addView(localLinearLayout);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    paramRelativeLayout.width = -1;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(12, -1);
    paramRelativeLayout.addRule(0, 2131374356);
    paramRelativeLayout.rightMargin = agej.a(20.0F, localResources);
    paramContext = new TextView(paramContext);
    localLinearLayout.addView(paramContext);
    paramRelativeLayout = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
    int i = agej.a(16.0F, localResources);
    paramRelativeLayout.bottomMargin = i;
    paramRelativeLayout.leftMargin = i;
    paramRelativeLayout.height = agej.a(28.0F, localResources);
    paramContext.setBackgroundResource(2130844416);
    paramContext.setTextColor(-1);
    paramContext.setTextSize(1, 12.0F);
    paramContext.setGravity(16);
    paramContext.setSingleLine(true);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    return paramContext;
  }
  
  public static avlz a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if ((paramStructMsgForImageShare == null) || (TextUtils.isEmpty(paramStructMsgForImageShare.mMsgActionData))) {
      return null;
    }
    try
    {
      paramStructMsgForImageShare = new JSONObject(paramStructMsgForImageShare.mMsgActionData);
      avlz localavlz = new avlz();
      localavlz.jdField_a_of_type_JavaLangString = paramStructMsgForImageShare.optString("game_source_pic_txt");
      localavlz.jdField_b_of_type_JavaLangString = paramStructMsgForImageShare.optString("game_source_pic_url");
      localavlz.jdField_a_of_type_Int = paramStructMsgForImageShare.optInt("game_source_type_pic", 0);
      localavlz.jdField_b_of_type_Int = paramStructMsgForImageShare.optInt("game_source_subtype_pic", 0);
      localavlz.jdField_a_of_type_Boolean = paramStructMsgForImageShare.optBoolean("game_source_pic_has_data");
      return localavlz;
    }
    catch (Throwable paramStructMsgForImageShare)
    {
      QLog.e("GameShare.Util", 1, paramStructMsgForImageShare, new Object[0]);
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramString1 = paramMessageRecord.getExtInfoFromExtStr(paramString1);
      if (!TextUtils.isEmpty(paramString1)) {}
    }
    else
    {
      return paramString2;
    }
    return paramString1;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public static void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean, Resources paramResources, Context paramContext, AbsStructMsg paramAbsStructMsg)
  {
    try
    {
      if (!a(paramAbsStructMsg)) {
        return;
      }
      localAbsShareMsg = (AbsShareMsg)paramAbsStructMsg;
      if ((paramView == null) || (paramRelativeLayout == null) || (paramResources == null) || (paramContext == null) || (paramAbsStructMsg == null) || (paramAbsStructMsg.message == null)) {
        return;
      }
      if (!(paramView instanceof TextView)) {
        break label739;
      }
      paramView = (TextView)paramView;
      paramView.setBackgroundDrawable(null);
      localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.addRule(15, -1);
      paramView.setLayoutParams(localLayoutParams);
    }
    catch (Throwable paramView)
    {
      AbsShareMsg localAbsShareMsg;
      RelativeLayout.LayoutParams localLayoutParams;
      int i;
      int j;
      while (QLog.isColorLevel())
      {
        QLog.e("GameShare.Util", 1, paramView, new Object[0]);
        return;
        localLayoutParams.rightMargin = agej.a(10.0F, paramResources);
        continue;
        label736:
        continue;
        label739:
        paramView = null;
      }
    }
    paramRelativeLayout.setBackgroundResource(2130842582);
    localLayoutParams = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.addRule(7, 2131364423);
      localLayoutParams.rightMargin = agej.a(10.0F, paramResources);
      paramRelativeLayout.setLayoutParams(localLayoutParams);
      paramContext = new TextView(paramContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(6, 2131378082);
      localLayoutParams.addRule(1, 2131378082);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(8, 2131378082);
      localLayoutParams.addRule(15, -1);
      localLayoutParams.rightMargin = agej.a(8.0F, paramResources);
      paramRelativeLayout.addView(paramContext, localLayoutParams);
      paramContext.setGravity(21);
      paramContext.setEllipsize(TextUtils.TruncateAt.END);
      paramContext.setSingleLine(true);
      paramContext.setTextColor(-1);
      paramContext.setTextSize(2, 12.0F);
      paramContext.setCompoundDrawablePadding(agej.a(5.0F, paramResources));
      paramRelativeLayout = paramResources.getDrawable(2130848541);
      paramRelativeLayout.setBounds(0, 0, agej.a(6.0F, paramResources), agej.a(10.0F, paramResources));
      paramContext.setCompoundDrawables(null, null, paramRelativeLayout, null);
      paramRelativeLayout = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&autodownload=1&autolaunch=1&autosubscribe=1&ADTAG=87006&appid=" + localAbsShareMsg.mSourceAppid;
      if (paramView != null)
      {
        paramView.setTag(-1, paramRelativeLayout);
        paramView.setTag(-5, Integer.valueOf(0));
        paramView.setOnClickListener(jdField_a_of_type_AndroidViewView$OnClickListener);
        alil.a(paramView, 0.5F);
      }
      paramView = a("game_source_aio_txt", "", paramAbsStructMsg.message);
      if (!TextUtils.isEmpty(paramView)) {
        break label736;
      }
      avls.a().a(localAbsShareMsg.mSourceAppid, localAbsShareMsg.message);
      paramView = "有新动态";
      paramResources = a("game_source_aio_url", "", paramAbsStructMsg.message);
      paramRelativeLayout = paramResources;
      if (TextUtils.isEmpty(paramResources)) {
        paramRelativeLayout = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87006&appid=" + localAbsShareMsg.mSourceAppid;
      }
      i = a("game_source_type_aio", 0, paramAbsStructMsg.message);
      j = a("game_source_subtype_aio", 0, paramAbsStructMsg.message);
      paramResources = localAbsShareMsg.mSourceAppid + "";
      paramContext.setText(paramView);
      paramContext.setTag(-1, paramRelativeLayout);
      paramContext.setTag(-2, Integer.valueOf(i));
      paramContext.setTag(-3, Integer.valueOf(j));
      paramContext.setTag(-4, paramResources);
      paramContext.setTag(-5, Integer.valueOf(1));
      paramContext.setOnClickListener(jdField_a_of_type_AndroidViewView$OnClickListener);
      alil.a(paramContext, 0.5F);
      paramView = (Integer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramAbsStructMsg.message.uniseq));
      if ((paramView != null) && (paramView.intValue() == j)) {
        return;
      }
      paramView = new HashMap();
      paramView.put(Integer.valueOf(2), j + "");
      paramView.put(Integer.valueOf(4), "8");
      acik.a(null, "870", "206672", paramResources, "87006", "1", "145", paramView);
      jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramAbsStructMsg.message.uniseq), Integer.valueOf(j));
    }
  }
  
  public static void a(TextView paramTextView, Context paramContext, AIOImageData paramAIOImageData, aics paramaics)
  {
    if ((paramTextView == null) || (paramContext == null) || (paramAIOImageData == null)) {
      return;
    }
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)bdow.a((byte[])paramAIOImageData.a);
    avlz localavlz = a(localStructMsgForImageShare);
    if ((localavlz != null) && (!TextUtils.isEmpty(localavlz.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localavlz.jdField_b_of_type_JavaLangString)))
    {
      Object localObject1 = localStructMsgForImageShare.mSourceAppid + "";
      paramTextView.setVisibility(0);
      paramTextView.setText(localavlz.jdField_a_of_type_JavaLangString);
      paramTextView.setTag(-1, localavlz.jdField_b_of_type_JavaLangString);
      paramTextView.setTag(-4, localObject1);
      paramTextView.setTag(-2, Integer.valueOf(localavlz.jdField_a_of_type_Int));
      paramTextView.setTag(-3, Integer.valueOf(localavlz.jdField_b_of_type_Int));
      paramTextView.setTag(-5, Integer.valueOf(2));
      a((String)localObject1, localavlz.jdField_b_of_type_Int, paramAIOImageData);
      paramTextView.setOnClickListener(jdField_a_of_type_AndroidViewView$OnClickListener);
      alil.a(paramTextView, 0.5F);
      localObject1 = localStructMsgForImageShare.mSourceIcon;
      Object localObject2 = paramContext.getResources();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject3 = ((Resources)localObject2).getDrawable(2130850462);
        ((Drawable)localObject3).setBounds(0, 0, agej.a(20.0F, (Resources)localObject2), agej.a(20.0F, (Resources)localObject2));
        Object localObject4 = new BitmapDrawable(bdqo.a((Drawable)localObject3));
        paramTextView.setCompoundDrawablePadding(agej.a(3.0F, (Resources)localObject2));
        ((Drawable)localObject4).setBounds(0, 0, agej.a(20.0F, (Resources)localObject2), agej.a(20.0F, (Resources)localObject2));
        paramTextView.setCompoundDrawables((Drawable)localObject4, null, null, null);
        localObject4 = ((Resources)localObject2).getDrawable(2130850463);
        ((Drawable)localObject4).setBounds(0, 0, agej.a(20.0F, (Resources)localObject2), agej.a(20.0F, (Resources)localObject2));
        localObject1 = URLDrawable.getDrawable((String)localObject1, (Drawable)localObject3, (Drawable)localObject4);
        localObject2 = new WeakReference(paramContext);
        localObject3 = new WeakReference(paramTextView);
        paramaics = new WeakReference(paramaics);
        long l1 = paramAIOImageData.jdField_f_of_type_Long;
        long l2 = paramAIOImageData.jdField_f_of_type_Int;
        QWalletPicHelper.decodeDrawable((Drawable)localObject1, new avlx((WeakReference)localObject2, (WeakReference)localObject3, paramaics, l1, l2));
        if (!localavlz.jdField_a_of_type_Boolean) {
          avls.a().a(localStructMsgForImageShare.mSourceAppid, new avly((WeakReference)localObject2, (WeakReference)localObject3, paramaics, l1, l2, paramAIOImageData));
        }
      }
    }
    for (;;)
    {
      paramContext = paramContext.getResources();
      paramTextView.setPadding(agej.a(5.0F, paramContext), 0, agej.a(14.0F, paramContext), 0);
      return;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void a(AIOImageData paramAIOImageData, StructMsgForImageShare paramStructMsgForImageShare)
  {
    if ((paramAIOImageData == null) || (paramStructMsgForImageShare == null)) {
      return;
    }
    String str1 = a("game_source_pic_txt", "", paramStructMsgForImageShare.message);
    String str2 = a("game_source_pic_url", "", paramStructMsgForImageShare.message);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        str1 = "有新动态";
        str2 = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87007&appid=" + paramStructMsgForImageShare.mSourceAppid;
      }
      a(paramAIOImageData, paramStructMsgForImageShare, str1, str2, a("game_source_type_pic", 0, paramStructMsgForImageShare.message), a("game_source_subtype_pic", 0, paramStructMsgForImageShare.message), bool);
      return;
    }
  }
  
  public static void a(AIOImageData paramAIOImageData, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("game_source_pic_txt", paramString1);
      localJSONObject.put("game_source_pic_url", paramString2);
      localJSONObject.put("game_source_type_pic", paramInt1);
      localJSONObject.put("game_source_subtype_pic", paramInt2);
      localJSONObject.put("game_source_pic_has_data", paramBoolean);
      paramStructMsgForImageShare.mMsgActionData = localJSONObject.toString();
      paramAIOImageData.a = paramStructMsgForImageShare.getBytes();
      return;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        QLog.e("GameShare.Util", 1, paramString1, new Object[0]);
      }
    }
  }
  
  public static void a(StructMsgForImageShare paramStructMsgForImageShare, View paramView)
  {
    if ((paramStructMsgForImageShare == null) || (!a(paramStructMsgForImageShare.mSourceAppid)) || (paramView == null) || (paramView.getResources() == null)) {
      return;
    }
    try
    {
      int j = paramStructMsgForImageShare.width;
      int k = paramStructMsgForImageShare.height;
      int i = agej.a(251.0F, paramView.getResources());
      j = i * (k / j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      paramStructMsgForImageShare = localLayoutParams;
      if (localLayoutParams == null) {
        paramStructMsgForImageShare = new ViewGroup.LayoutParams(i, j);
      }
      paramStructMsgForImageShare.width = i;
      paramStructMsgForImageShare.height = j;
      paramView.setLayoutParams(paramStructMsgForImageShare);
      return;
    }
    catch (Throwable paramStructMsgForImageShare) {}
  }
  
  public static void a(String paramString, int paramInt, Object paramObject)
  {
    Object localObject = (Integer)jdField_a_of_type_JavaUtilMap.get(paramObject);
    if ((localObject == null) || (((Integer)localObject).intValue() != paramInt))
    {
      localObject = new HashMap();
      ((Map)localObject).put(Integer.valueOf(2), paramInt + "");
      ((Map)localObject).put(Integer.valueOf(4), "8");
      acik.a(null, "870", "206673", paramString, "87007", "1", "145", (Map)localObject);
      jdField_a_of_type_JavaUtilMap.put(paramObject, Integer.valueOf(paramInt));
    }
  }
  
  public static void a(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString2))) {
      paramMessageRecord.saveExtInfoToExtStr(paramString1, paramString2);
    }
  }
  
  public static boolean a(long paramLong)
  {
    try
    {
      avlq localavlq = avlr.a();
      if (localavlq != null)
      {
        boolean bool = localavlq.a(paramLong + "");
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GameShare.Util", 1, localThrowable, new Object[0]);
      }
    }
    return false;
  }
  
  public static boolean a(AbsShareMsg paramAbsShareMsg)
  {
    return (paramAbsShareMsg != null) && (a(paramAbsShareMsg.mSourceAppid));
  }
  
  private static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof AbsShareMsg)) {
      return a((AbsShareMsg)paramAbsStructMsg);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlv
 * JD-Core Version:    0.7.0.1
 */