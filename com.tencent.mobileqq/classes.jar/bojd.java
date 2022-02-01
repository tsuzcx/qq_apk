import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.camera.core.AEEditorGenerateBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AEEditorUIBroadcastReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class bojd
  implements bojc, bojj
{
  private AEEditorGenerateBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorGenerateBroadcastReceiver = new AEEditorGenerateBroadcastReceiver(this);
  private AEEditorUIBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorUIBroadcastReceiver = new AEEditorUIBroadcastReceiver(this);
  private final String jdField_a_of_type_JavaLangString = "AEEditorManagerForQzone";
  private List<bojf> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<String, LocalMediaInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private List<bojg> b = new CopyOnWriteArrayList();
  
  public static bojd a()
  {
    return bojh.a;
  }
  
  private void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      bpam.d("AEEditorManagerForQzone", "[sendBroadCast] action or missionID is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction(paramString1);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_mission", paramString2);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public LocalMediaInfo a(String paramString)
  {
    paramString = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public void a()
  {
    bpam.b("AEEditorManagerForQzone", "[init]");
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorGenerateBroadcastReceiver.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorUIBroadcastReceiver.a(BaseApplicationImpl.getContext());
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bojg)localIterator.next()).i(paramInt);
    }
  }
  
  public void a(@Nullable bojf parambojf)
  {
    bpam.b("AEEditorManagerForQzone", "[addListener]");
    if ((parambojf != null) && (!this.jdField_a_of_type_JavaUtilList.contains(parambojf))) {
      this.jdField_a_of_type_JavaUtilList.add(parambojf);
    }
  }
  
  public void a(@Nullable bojg parambojg)
  {
    bpam.b("AEEditorManagerForQzone", "[addUICallbackListener]");
    if ((parambojg != null) && (!this.b.contains(parambojg))) {
      this.b.add(parambojg);
    }
  }
  
  public void a(@NonNull String paramString)
  {
    bpam.b("AEEditorManagerForQzone", "[cancel]");
    a("AEEDITOR_ORDER_CANCEL", paramString);
  }
  
  public void a(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bpam.d("AEEditorManagerForQzone", "[onAETavSessionExporting] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null)
    {
      localObject = bpkw.a("", 0, 0, null, null, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bojf)((Iterator)localObject).next()).onAETavSessionExporting(paramString, paramFloat);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bpam.d("AEEditorManagerForQzone", "[onAETavSessionExportError] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null)
    {
      localObject = bpkw.a("", 0, 0, null, null, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bojf)((Iterator)localObject).next()).onAETavSessionExportError(paramString, paramInt);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (TextUtils.isEmpty(paramString6)) {
      bpam.d("AEEditorManagerForQzone", "[onAETavSessionExportCompleted] mission is null");
    }
    for (;;)
    {
      return;
      paramString1 = bpkw.a(paramString1, paramString7, paramString8);
      if (paramString1 == null)
      {
        a(paramString6, -4);
        return;
      }
      paramString1.materialID = paramString2;
      paramString1.materialName = paramString3;
      paramString1.filterID = paramString4;
      paramString1.scheme = paramString5;
      paramString1.missionID = paramString6;
      bozr.a().a(paramString1);
      this.jdField_a_of_type_JavaUtilMap.put(paramString6, paramString1);
      paramString2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString2.hasNext()) {
        ((bojf)paramString2.next()).onAETavSessionExportCompleted(paramString6, paramString1);
      }
    }
  }
  
  public void b(@Nullable bojf parambojf)
  {
    bpam.b("AEEditorManagerForQzone", "[removeListener]");
    if ((parambojf != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambojf))) {
      this.jdField_a_of_type_JavaUtilList.remove(parambojf);
    }
  }
  
  public void b(@Nullable bojg parambojg)
  {
    bpam.b("AEEditorManagerForQzone", "[removeCallbackListener]");
    if ((parambojg != null) && (this.b.contains(parambojg))) {
      this.b.remove(parambojg);
    }
  }
  
  public void b(String paramString)
  {
    bpam.b("AEEditorManagerForQzone", "[save]");
    a("AEEDITOR_ORDER_SAVE", paramString);
  }
  
  public void c(String paramString)
  {
    bpam.b("AEEditorManagerForQzone", "[retry]");
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), PeakService.class);
    localIntent.putExtra("ServiceAction", 4);
    localIntent.putExtra("generate_mission", paramString);
    BaseApplicationImpl.getApplication().startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojd
 * JD-Core Version:    0.7.0.1
 */