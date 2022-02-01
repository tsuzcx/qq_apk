import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import dov.com.qq.im.ae.download.AEResDownload.1;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class bnpr
{
  private static Map<String, ShortVideoResourceManager.SVConfigItem> a = new ConcurrentHashMap();
  
  public static void a(@NonNull bnpt parambnpt, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcfe parambcfe)
  {
    ThreadManager.excute(new AEResDownload.1(parambnpt, paramList, parambcfe), 128, null, false);
  }
  
  private static void c(@NonNull bnpt parambnpt, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcfe parambcfe)
  {
    int i;
    Object localObject;
    if ((lkw.d()) && (Build.VERSION.SDK_INT >= 15))
    {
      bnzb.b("AEResDownload", "support isNeon");
      i = 0;
      if (i >= paramList.size()) {
        break label467;
      }
      localObject = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
      if ((!((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(parambnpt.b)) || (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode != parambnpt.c)) {
        break label116;
      }
    }
    label413:
    label425:
    label467:
    for (paramList = (List<ShortVideoResourceManager.SVConfigItem>)localObject;; paramList = null)
    {
      if (paramList == null)
      {
        bnzb.d("AEResDownload", "[realDownloadResource EROOR]");
        parambcfe.a("", -101, null);
        return;
        bnzb.d("AEResDownload", "Neon is not Support");
        parambcfe.a("", -1, null);
        return;
        label116:
        i += 1;
        break;
      }
      i = bnpy.a(parambnpt.jdField_a_of_type_Int);
      if (i >= Integer.valueOf(paramList.name.substring(parambnpt.b.length())).intValue())
      {
        if (TextUtils.isEmpty(bnpy.a(parambnpt))) {
          bnzb.d("AEResDownload", "[realDownloadResourceInternal] local exist but finalPath is null");
        }
      }
      else
      {
        localObject = new bdvs();
        ((bdvs)localObject).jdField_a_of_type_Bdvw = new bnps(parambcfe, parambnpt);
        if ((!bcgg.a()) || (!paramList.check64BitReady())) {
          break label413;
        }
        ((bdvs)localObject).jdField_a_of_type_JavaLangString = paramList.arm64v8a_url;
        label217:
        ((bdvs)localObject).jdField_a_of_type_Int = 0;
        ((bdvs)localObject).c = (bnpy.c() + paramList.name);
        ((bdvs)localObject).b = bgnt.a(bdwu.a().a());
        ((bdvs)localObject).n = true;
        ((bdvs)localObject).a(paramList.name);
        parambnpt = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (parambnpt != null) {
          break label425;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          bnzb.d("AEResDownload", "[realDownloadResourceInternal] need new DownLoadEngine");
          parambnpt = new bgut(parambnpt, 4);
          parambnpt.a();
          new bdwv(parambnpt, false).a((bdws)localObject);
        }
        a.put(paramList.name, paramList);
        return;
        if (TextUtils.isEmpty(bnpy.b(parambnpt)))
        {
          bnzb.d("AEResDownload", "[realDownloadResourceInternal] local exist but unzipPath is null");
          break;
        }
        bnzb.d("AEResDownload", "[realDownloadResource info] local exist");
        parambcfe.a(paramList.name, 1, bnpy.a(parambnpt.b + i));
        return;
        ((bdvs)localObject).jdField_a_of_type_JavaLangString = paramList.armv7a_url;
        break label217;
        if (parambnpt.getManager(21) == null)
        {
          i = 1;
        }
        else
        {
          parambcfe = parambnpt.getNetEngine(0);
          if (parambcfe == null)
          {
            i = 1;
          }
          else
          {
            parambcfe.a((bdws)localObject);
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpr
 * JD-Core Version:    0.7.0.1
 */