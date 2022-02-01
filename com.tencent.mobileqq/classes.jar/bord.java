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

public class bord
{
  private static Map<String, ShortVideoResourceManager.SVConfigItem> a = new ConcurrentHashMap();
  
  public static void a(@NonNull borf paramborf, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcxw parambcxw)
  {
    ThreadManager.excute(new AEResDownload.1(paramborf, paramList, parambcxw), 128, null, false);
  }
  
  private static void c(@NonNull borf paramborf, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcxw parambcxw)
  {
    int i;
    Object localObject;
    if ((llk.d()) && (Build.VERSION.SDK_INT >= 15))
    {
      bpam.b("AEResDownload", "support isNeon");
      i = 0;
      if (i >= paramList.size()) {
        break label467;
      }
      localObject = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
      if ((!((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(paramborf.b)) || (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode != paramborf.c)) {
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
        bpam.d("AEResDownload", "[realDownloadResource EROOR]");
        parambcxw.a("", -101, null);
        return;
        bpam.d("AEResDownload", "Neon is not Support");
        parambcxw.a("", -1, null);
        return;
        label116:
        i += 1;
        break;
      }
      i = bork.a(paramborf.jdField_a_of_type_Int);
      if (i >= Integer.valueOf(paramList.name.substring(paramborf.b.length())).intValue())
      {
        if (TextUtils.isEmpty(bork.a(paramborf))) {
          bpam.d("AEResDownload", "[realDownloadResourceInternal] local exist but finalPath is null");
        }
      }
      else
      {
        localObject = new beum();
        ((beum)localObject).jdField_a_of_type_Beuq = new bore(parambcxw, paramborf);
        if ((!bcyy.a()) || (!paramList.check64BitReady())) {
          break label413;
        }
        ((beum)localObject).jdField_a_of_type_JavaLangString = paramList.arm64v8a_url;
        label217:
        ((beum)localObject).jdField_a_of_type_Int = 0;
        ((beum)localObject).c = (bork.c() + paramList.name);
        ((beum)localObject).b = bhnv.a(bevn.a().a());
        ((beum)localObject).n = true;
        ((beum)localObject).a(paramList.name);
        paramborf = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramborf != null) {
          break label425;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          bpam.d("AEResDownload", "[realDownloadResourceInternal] need new DownLoadEngine");
          paramborf = new bhuw(paramborf, 4);
          paramborf.a();
          new bevo(paramborf, false).a((bevl)localObject);
        }
        a.put(paramList.name, paramList);
        return;
        if (TextUtils.isEmpty(bork.b(paramborf)))
        {
          bpam.d("AEResDownload", "[realDownloadResourceInternal] local exist but unzipPath is null");
          break;
        }
        bpam.d("AEResDownload", "[realDownloadResource info] local exist");
        parambcxw.a(paramList.name, 1, bork.a(paramborf.b + i));
        return;
        ((beum)localObject).jdField_a_of_type_JavaLangString = paramList.armv7a_url;
        break label217;
        if (paramborf.getManager(21) == null)
        {
          i = 1;
        }
        else
        {
          parambcxw = paramborf.getNetEngine(0);
          if (parambcxw == null)
          {
            i = 1;
          }
          else
          {
            parambcxw.a((bevl)localObject);
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bord
 * JD-Core Version:    0.7.0.1
 */