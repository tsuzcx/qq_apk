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

public class bpkr
{
  public static void a(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bpku parambpku)
  {
    bpam.a("AEEditorPagStickerUtil", "[preparePagSticker] - BEGIN -");
    if (parambpku != null) {
      parambpku.a(paramAEEditorTextBean, 0);
    }
    if (bphr.a().a(paramAEEditorTextBean.id))
    {
      bpam.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file exists");
      ThreadManager.excute(new AEEditorPagStickerUtil.1(paramAEEditorTextBean, parambpku), 64, null, false);
    }
    for (;;)
    {
      bpam.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
      return;
      bpam.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file not exists");
      AEEditorPagStickerInfo localAEEditorPagStickerInfo = bphr.a().a(paramAEEditorTextBean.id);
      if (localAEEditorPagStickerInfo == null)
      {
        if (parambpku != null) {
          parambpku.a(paramAEEditorTextBean, false, "ERROR_PAG_ZIP_INFO_NOT_FOUND");
        }
        bpam.a("AEEditorPagStickerUtil", "[preparePagSticker] invalid sticker info");
        bpam.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.2(AEEditorPagStickerInfo.convert2DownloadBean(localAEEditorPagStickerInfo), paramAEEditorTextBean, parambpku), 128, null, false);
    }
  }
  
  private static void b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bpku parambpku)
  {
    bpam.a("AEEditorPagStickerUtil", "[downloadPagZip] - BEGIN -");
    bphr.a().a(paramAEEditorDownloadResBean, new bpks(paramAEEditorTextBean, parambpku));
    bpam.a("AEEditorPagStickerUtil", "[downloadPagZip] - END -");
  }
  
  private static void b(AEEditorTextBean paramAEEditorTextBean, @NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @Nullable bpku parambpku)
  {
    bpam.a("AEEditorPagStickerUtil", "[downloadPagFont] - BEGIN -");
    bphr.a().a(paramAEEditorDownloadResBean, new bpkt(parambpku, paramAEEditorTextBean));
    bpam.a("AEEditorPagStickerUtil", "[downloadPagFont] - END -");
  }
  
  private static void d(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bpku parambpku)
  {
    boolean bool = false;
    bpam.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - BEGIN -");
    Object localObject = bphr.a().d(paramAEEditorTextBean.id);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (parambpku != null) {
        parambpku.a(paramAEEditorTextBean, false, null);
      }
      bpam.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] invalid config json path");
      bpam.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
      return;
    }
    localObject = bphr.a().a((String)localObject);
    if (parambpku != null)
    {
      if (localObject != null) {
        bool = true;
      }
      parambpku.a(paramAEEditorTextBean, bool, (AEEditorPagStickerConfig)localObject);
    }
    bpam.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
  }
  
  private static void e(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bpku parambpku)
  {
    bpam.a("AEEditorPagStickerUtil", "[preparePagFont] - BEGIN -");
    if (parambpku != null) {
      parambpku.a(paramAEEditorTextBean, 66);
    }
    if (!TextUtils.isEmpty(paramAEEditorTextBean.fontId))
    {
      bpam.a("AEEditorPagStickerUtil", "[preparePagFont] font info configured");
      f(paramAEEditorTextBean, parambpku);
    }
    for (;;)
    {
      bpam.a("AEEditorPagStickerUtil", "[preparePagFont] - END -");
      return;
      bpam.a("AEEditorPagStickerUtil", "[preparePagFont] font info not configured");
      if (parambpku != null)
      {
        parambpku.a(paramAEEditorTextBean, 100);
        parambpku.a(paramAEEditorTextBean, true, "SUCCESS_FONT_NOT_CONFIGURED");
      }
    }
  }
  
  private static void f(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bpku parambpku)
  {
    bpam.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - BEGIN -");
    AEEditorDownloadResBean localAEEditorDownloadResBean = bphr.a().a(paramAEEditorTextBean.fontId);
    if (localAEEditorDownloadResBean == null)
    {
      if (parambpku != null) {
        parambpku.a(paramAEEditorTextBean, false, "ERROR_FONT_INFO_NOT_FOUND");
      }
      bpam.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] invalid font info");
      bpam.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
    }
    if (bphr.a().a(localAEEditorDownloadResBean))
    {
      bpam.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file exists");
      if (parambpku != null)
      {
        parambpku.a(paramAEEditorTextBean, 100);
        parambpku.a(paramAEEditorTextBean, true, "SUCCESS_FONT_EXISTED");
      }
    }
    for (;;)
    {
      bpam.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
      bpam.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file not exists");
      if (bphr.a().b(localAEEditorDownloadResBean.getId()))
      {
        if (parambpku != null) {
          parambpku.a(paramAEEditorTextBean, true, "SUCCESS_FONT_LIMIT_EXCEEDED");
        }
        bpam.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] used fonts exceeded limit");
        bpam.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.4(paramAEEditorTextBean, localAEEditorDownloadResBean, parambpku), 128, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkr
 * JD-Core Version:    0.7.0.1
 */