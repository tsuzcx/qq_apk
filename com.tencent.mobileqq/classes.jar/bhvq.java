import QC.GetWatchWordShareRsp;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.watchword.VasWatchWord.showContentDialog.jumpDialog.1;
import com.tencent.qphone.base.util.BaseApplication;
import eipc.EIPCResultCallback;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/watchword/VasWatchWord;", "", "()V", "ERROR_BID", "", "ERR_WATCHWORD_EXPIRED", "ERR_WATCHWORD_ITEM_VALID", "ERR_WATCHWORD_USED", "RET_SUCCESS", "addObserver", "", "clearClipboard", "copyToClipboard", "watchWord", "", "getBid", "url", "(Ljava/lang/String;)Ljava/lang/Integer;", "invalidateDialog", "context", "Landroid/content/Context;", "errmsg", "shareWatchWord", "shareUrl", "showContentDialog", "rsp", "LQC/GetWatchWordShareRsp;", "startWebView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhvq
{
  public static final bhvq a = new bhvq();
  
  @Nullable
  public final Integer a(@NotNull String paramString)
  {
    Object localObject = null;
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"?", false, 2, null)))
    {
      paramString = ((Collection)StringsKt.split$default((CharSequence)paramString, new String[] { "?" }, false, 0, 6, null)).toArray(new String[0]);
      if (paramString == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      paramString = bjht.a(((String[])paramString)[1]);
      String str = (String)paramString.get("appid");
      paramString = (String)paramString.get("itemid");
      if ((!TextUtils.isEmpty((CharSequence)str)) && (!TextUtils.isEmpty((CharSequence)paramString)))
      {
        paramString = localObject;
        if (str != null) {
          paramString = Integer.valueOf(Integer.parseInt(str));
        }
        return paramString;
      }
    }
    return Integer.valueOf(-1);
  }
  
  public final void a()
  {
    rlt.a.a().a((rlv)new bhvr());
  }
  
  public final void a(@NotNull GetWatchWordShareRsp paramGetWatchWordShareRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetWatchWordShareRsp, "rsp");
    Object localObject = paramGetWatchWordShareRsp.detailurl;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rsp.detailurl");
    localObject = a((String)localObject);
    if (localObject != null) {}
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      localObject = BaseActivity.sTopActivity;
      if (localObject == null) {
        return;
      }
      localObject = ((BaseActivity)localObject).getWindow();
      if (localObject == null) {
        return;
      }
      localObject = ((Window)localObject).getDecorView();
      if (localObject == null) {
        return;
      }
      if (localObject != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    String str1 = paramGetWatchWordShareRsp.shareuinnick;
    Intrinsics.checkExpressionValueIsNotNull(str1, "rsp.shareuinnick");
    String str2 = paramGetWatchWordShareRsp.sharemsg;
    Intrinsics.checkExpressionValueIsNotNull(str2, "rsp.sharemsg");
    localObject = new bhvu((ViewGroup)localObject, str1, str2, (Function1)new VasWatchWord.showContentDialog.jumpDialog.1(paramGetWatchWordShareRsp, i));
    str1 = paramGetWatchWordShareRsp.itemmsg;
    Intrinsics.checkExpressionValueIsNotNull(str1, "rsp.itemmsg");
    ((bhvu)localObject).a(str1);
    int j = paramGetWatchWordShareRsp.portrait;
    paramGetWatchWordShareRsp = paramGetWatchWordShareRsp.thumbnailurl;
    Intrinsics.checkExpressionValueIsNotNull(paramGetWatchWordShareRsp, "rsp.thumbnailurl");
    ((bhvu)localObject).a(j, paramGetWatchWordShareRsp);
    ((bhvu)localObject).a();
    bdla.b(null, "dc00898", "", "", "qq_vip", "0X800AF79", i, 0, "", "", "", "");
  }
  
  public final void a(@Nullable Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "shareUrl");
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"?", false, 2, null))
    {
      znl.a(1, 2131720060);
      return;
    }
    paramContext = ((Collection)StringsKt.split$default((CharSequence)paramString, new String[] { "?" }, false, 0, 6, null)).toArray(new String[0]);
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    paramString = bjht.a(((String[])paramContext)[1]);
    paramContext = (String)paramString.get("itemid");
    paramString = (String)paramString.get("appid");
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (TextUtils.isEmpty((CharSequence)paramContext)))
    {
      znl.a(1, 2131720060);
      return;
    }
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    bdla.b(null, "dc00898", "", "", "qq_vip", "0X800AF78", Integer.parseInt(paramString), 0, paramContext, "", "", "");
    Object localObject = RemoteProxy.getProxy(bhss.class);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.remote.IWatchWordProtocol");
    }
    ((bhsr)localObject).a(paramString, paramContext, null, -1, (EIPCResultCallback)new bhvt(paramString, paramContext));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "watchWord");
    ClipboardManager localClipboardManager = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
    if (localClipboardManager != null) {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText((CharSequence)"RIJShareClip", (CharSequence)paramString));
    }
  }
  
  public final void b()
  {
    ClipboardManager localClipboardManager = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
    if (localClipboardManager != null) {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, (CharSequence)""));
    }
  }
  
  public final void b(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public final void c(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "errmsg");
    bhdj.a(paramContext, 230, paramContext.getString(2131720063), (CharSequence)paramString, null, paramContext.getString(2131720062), (DialogInterface.OnClickListener)new bhdx(), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvq
 * JD-Core Version:    0.7.0.1
 */