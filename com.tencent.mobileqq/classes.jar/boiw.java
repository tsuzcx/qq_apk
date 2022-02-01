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

public class boiw
{
  public static void a(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable boiz paramboiz)
  {
    bnzb.a("AEEditorPagStickerUtil", "[preparePagSticker] - BEGIN -");
    if (paramboiz != null) {
      paramboiz.a(paramAEEditorTextBean, 0);
    }
    if (bofw.a().a(paramAEEditorTextBean.id))
    {
      bnzb.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file exists");
      ThreadManager.excute(new AEEditorPagStickerUtil.1(paramAEEditorTextBean, paramboiz), 64, null, false);
    }
    for (;;)
    {
      bnzb.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
      return;
      bnzb.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file not exists");
      AEEditorPagStickerInfo localAEEditorPagStickerInfo = bofw.a().a(paramAEEditorTextBean.id);
      if (localAEEditorPagStickerInfo == null)
      {
        if (paramboiz != null) {
          paramboiz.a(paramAEEditorTextBean, false, "ERROR_PAG_ZIP_INFO_NOT_FOUND");
        }
        bnzb.a("AEEditorPagStickerUtil", "[preparePagSticker] invalid sticker info");
        bnzb.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.2(AEEditorPagStickerInfo.convert2DownloadBean(localAEEditorPagStickerInfo), paramAEEditorTextBean, paramboiz), 128, null, false);
    }
  }
  
  private static void b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable boiz paramboiz)
  {
    bnzb.a("AEEditorPagStickerUtil", "[downloadPagZip] - BEGIN -");
    bofw.a().a(paramAEEditorDownloadResBean, new boix(paramAEEditorTextBean, paramboiz));
    bnzb.a("AEEditorPagStickerUtil", "[downloadPagZip] - END -");
  }
  
  private static void b(AEEditorTextBean paramAEEditorTextBean, @NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @Nullable boiz paramboiz)
  {
    bnzb.a("AEEditorPagStickerUtil", "[downloadPagFont] - BEGIN -");
    bofw.a().a(paramAEEditorDownloadResBean, new boiy(paramboiz, paramAEEditorTextBean));
    bnzb.a("AEEditorPagStickerUtil", "[downloadPagFont] - END -");
  }
  
  private static void d(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable boiz paramboiz)
  {
    boolean bool = false;
    bnzb.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - BEGIN -");
    Object localObject = bofw.a().d(paramAEEditorTextBean.id);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (paramboiz != null) {
        paramboiz.a(paramAEEditorTextBean, false, null);
      }
      bnzb.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] invalid config json path");
      bnzb.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
      return;
    }
    localObject = bofw.a().a((String)localObject);
    if (paramboiz != null)
    {
      if (localObject != null) {
        bool = true;
      }
      paramboiz.a(paramAEEditorTextBean, bool, (AEEditorPagStickerConfig)localObject);
    }
    bnzb.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
  }
  
  private static void e(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable boiz paramboiz)
  {
    bnzb.a("AEEditorPagStickerUtil", "[preparePagFont] - BEGIN -");
    if (paramboiz != null) {
      paramboiz.a(paramAEEditorTextBean, 66);
    }
    if (!TextUtils.isEmpty(paramAEEditorTextBean.fontId))
    {
      bnzb.a("AEEditorPagStickerUtil", "[preparePagFont] font info configured");
      f(paramAEEditorTextBean, paramboiz);
    }
    for (;;)
    {
      bnzb.a("AEEditorPagStickerUtil", "[preparePagFont] - END -");
      return;
      bnzb.a("AEEditorPagStickerUtil", "[preparePagFont] font info not configured");
      if (paramboiz != null)
      {
        paramboiz.a(paramAEEditorTextBean, 100);
        paramboiz.a(paramAEEditorTextBean, true, "SUCCESS_FONT_NOT_CONFIGURED");
      }
    }
  }
  
  private static void f(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable boiz paramboiz)
  {
    bnzb.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - BEGIN -");
    AEEditorDownloadResBean localAEEditorDownloadResBean = bofw.a().a(paramAEEditorTextBean.fontId);
    if (localAEEditorDownloadResBean == null)
    {
      if (paramboiz != null) {
        paramboiz.a(paramAEEditorTextBean, false, "ERROR_FONT_INFO_NOT_FOUND");
      }
      bnzb.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] invalid font info");
      bnzb.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
    }
    if (bofw.a().a(localAEEditorDownloadResBean))
    {
      bnzb.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file exists");
      if (paramboiz != null)
      {
        paramboiz.a(paramAEEditorTextBean, 100);
        paramboiz.a(paramAEEditorTextBean, true, "SUCCESS_FONT_EXISTED");
      }
    }
    for (;;)
    {
      bnzb.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
      bnzb.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file not exists");
      if (bofw.a().b(localAEEditorDownloadResBean.getId()))
      {
        if (paramboiz != null) {
          paramboiz.a(paramAEEditorTextBean, true, "SUCCESS_FONT_LIMIT_EXCEEDED");
        }
        bnzb.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] used fonts exceeded limit");
        bnzb.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.4(paramAEEditorTextBean, localAEEditorDownloadResBean, paramboiz), 128, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boiw
 * JD-Core Version:    0.7.0.1
 */