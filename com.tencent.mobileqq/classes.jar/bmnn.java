import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.1;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.2;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.4;

public class bmnn
{
  public static void a(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bmnq parambmnq)
  {
    bmbx.a("AEEditorPagStickerUtil", "[preparePagSticker] - BEGIN -");
    if (parambmnq != null) {
      parambmnq.a(paramAEEditorTextBean, 0);
    }
    if (bmkn.a().a(paramAEEditorTextBean.id))
    {
      bmbx.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file exists");
      ThreadManager.excute(new AEEditorPagStickerUtil.1(paramAEEditorTextBean, parambmnq), 64, null, false);
    }
    for (;;)
    {
      bmbx.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
      return;
      bmbx.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file not exists");
      AEEditorPagStickerInfo localAEEditorPagStickerInfo = bmkn.a().a(paramAEEditorTextBean.id);
      if (localAEEditorPagStickerInfo == null)
      {
        if (parambmnq != null) {
          parambmnq.a(paramAEEditorTextBean, false, "ERROR_PAG_ZIP_INFO_NOT_FOUND");
        }
        bmbx.a("AEEditorPagStickerUtil", "[preparePagSticker] invalid sticker info");
        bmbx.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.2(AEEditorPagStickerInfo.convert2DownloadBean(localAEEditorPagStickerInfo), paramAEEditorTextBean, parambmnq), 128, null, false);
    }
  }
  
  private static void b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bmnq parambmnq)
  {
    bmbx.a("AEEditorPagStickerUtil", "[downloadPagZip] - BEGIN -");
    bmkn.a().a(paramAEEditorDownloadResBean, new bmno(paramAEEditorTextBean, parambmnq));
    bmbx.a("AEEditorPagStickerUtil", "[downloadPagZip] - END -");
  }
  
  private static void b(AEEditorTextBean paramAEEditorTextBean, @NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @Nullable bmnq parambmnq)
  {
    bmbx.a("AEEditorPagStickerUtil", "[downloadPagFont] - BEGIN -");
    bmkn.a().a(paramAEEditorDownloadResBean, new bmnp(parambmnq, paramAEEditorTextBean));
    bmbx.a("AEEditorPagStickerUtil", "[downloadPagFont] - END -");
  }
  
  private static void d(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bmnq parambmnq)
  {
    boolean bool = false;
    bmbx.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - BEGIN -");
    Object localObject = bmkn.a().d(paramAEEditorTextBean.id);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (parambmnq != null) {
        parambmnq.a(paramAEEditorTextBean, false, null);
      }
      bmbx.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] invalid config json path");
      bmbx.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
      return;
    }
    localObject = bmkn.a().a((String)localObject);
    if (parambmnq != null)
    {
      if (localObject != null) {
        bool = true;
      }
      parambmnq.a(paramAEEditorTextBean, bool, (AEEditorPagStickerConfig)localObject);
    }
    bmbx.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
  }
  
  private static void e(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bmnq parambmnq)
  {
    bmbx.a("AEEditorPagStickerUtil", "[preparePagFont] - BEGIN -");
    if (parambmnq != null) {
      parambmnq.a(paramAEEditorTextBean, 66);
    }
    if (!TextUtils.isEmpty(paramAEEditorTextBean.fontId))
    {
      bmbx.a("AEEditorPagStickerUtil", "[preparePagFont] font info configured");
      f(paramAEEditorTextBean, parambmnq);
    }
    for (;;)
    {
      bmbx.a("AEEditorPagStickerUtil", "[preparePagFont] - END -");
      return;
      bmbx.a("AEEditorPagStickerUtil", "[preparePagFont] font info not configured");
      if (parambmnq != null)
      {
        parambmnq.a(paramAEEditorTextBean, 100);
        parambmnq.a(paramAEEditorTextBean, true, "SUCCESS_FONT_NOT_CONFIGURED");
      }
    }
  }
  
  private static void f(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bmnq parambmnq)
  {
    bmbx.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - BEGIN -");
    AEEditorDownloadResBean localAEEditorDownloadResBean = bmkn.a().a(paramAEEditorTextBean.fontId);
    if (localAEEditorDownloadResBean == null)
    {
      if (parambmnq != null) {
        parambmnq.a(paramAEEditorTextBean, false, "ERROR_FONT_INFO_NOT_FOUND");
      }
      bmbx.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] invalid font info");
      bmbx.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
    }
    if (bmkn.a().a(localAEEditorDownloadResBean))
    {
      bmbx.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file exists");
      if (parambmnq != null)
      {
        parambmnq.a(paramAEEditorTextBean, 100);
        parambmnq.a(paramAEEditorTextBean, true, "SUCCESS_FONT_EXISTED");
      }
    }
    for (;;)
    {
      bmbx.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
      bmbx.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file not exists");
      if (bmkn.a().b(localAEEditorDownloadResBean.getId()))
      {
        if (parambmnq != null) {
          parambmnq.a(paramAEEditorTextBean, true, "SUCCESS_FONT_LIMIT_EXCEEDED");
        }
        bmbx.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] used fonts exceeded limit");
        bmbx.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.4(paramAEEditorTextBean, localAEEditorDownloadResBean, parambmnq), 128, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnn
 * JD-Core Version:    0.7.0.1
 */