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

public class bnhv
  implements bnhu, bnib
{
  private AEEditorGenerateBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorGenerateBroadcastReceiver = new AEEditorGenerateBroadcastReceiver(this);
  private AEEditorUIBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorUIBroadcastReceiver = new AEEditorUIBroadcastReceiver(this);
  private final String jdField_a_of_type_JavaLangString = "AEEditorManagerForQzone";
  private List<bnhx> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<String, LocalMediaInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private List<bnhy> b = new CopyOnWriteArrayList();
  
  public static bnhv a()
  {
    return bnhz.a;
  }
  
  private void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      bnzb.d("AEEditorManagerForQzone", "[sendBroadCast] action or missionID is null");
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
    bnzb.b("AEEditorManagerForQzone", "[init]");
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorGenerateBroadcastReceiver.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorUIBroadcastReceiver.a(BaseApplicationImpl.getContext());
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bnhy)localIterator.next()).i(paramInt);
    }
  }
  
  public void a(@Nullable bnhx parambnhx)
  {
    bnzb.b("AEEditorManagerForQzone", "[addListener]");
    if ((parambnhx != null) && (!this.jdField_a_of_type_JavaUtilList.contains(parambnhx))) {
      this.jdField_a_of_type_JavaUtilList.add(parambnhx);
    }
  }
  
  public void a(@Nullable bnhy parambnhy)
  {
    bnzb.b("AEEditorManagerForQzone", "[addUICallbackListener]");
    if ((parambnhy != null) && (!this.b.contains(parambnhy))) {
      this.b.add(parambnhy);
    }
  }
  
  public void a(@NonNull String paramString)
  {
    bnzb.b("AEEditorManagerForQzone", "[cancel]");
    a("AEEDITOR_ORDER_CANCEL", paramString);
  }
  
  public void a(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bnzb.d("AEEditorManagerForQzone", "[onAETavSessionExporting] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null)
    {
      localObject = bojb.a(0, 0, null, null, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bnhx)((Iterator)localObject).next()).onAETavSessionExporting(paramString, paramFloat);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bnzb.d("AEEditorManagerForQzone", "[onAETavSessionExportError] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null)
    {
      localObject = bojb.a(0, 0, null, null, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bnhx)((Iterator)localObject).next()).onAETavSessionExportError(paramString, paramInt);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (TextUtils.isEmpty(paramString5)) {
      bnzb.d("AEEditorManagerForQzone", "[onAETavSessionExportCompleted] mission is null");
    }
    for (;;)
    {
      return;
      paramString6 = bojb.a(paramString6, paramString7);
      paramString6.materialID = paramString1;
      paramString6.materialName = paramString2;
      paramString6.filterID = paramString3;
      paramString6.scheme = paramString4;
      paramString6.missionID = paramString5;
      if (paramString6 == null)
      {
        a(paramString5, -4);
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString5, paramString6);
      paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString1.hasNext()) {
        ((bnhx)paramString1.next()).onAETavSessionExportCompleted(paramString5, paramString6);
      }
    }
  }
  
  public void b(@Nullable bnhx parambnhx)
  {
    bnzb.b("AEEditorManagerForQzone", "[removeListener]");
    if ((parambnhx != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambnhx))) {
      this.jdField_a_of_type_JavaUtilList.remove(parambnhx);
    }
  }
  
  public void b(@Nullable bnhy parambnhy)
  {
    bnzb.b("AEEditorManagerForQzone", "[removeCallbackListener]");
    if ((parambnhy != null) && (this.b.contains(parambnhy))) {
      this.b.remove(parambnhy);
    }
  }
  
  public void b(String paramString)
  {
    bnzb.b("AEEditorManagerForQzone", "[save]");
    a("AEEDITOR_ORDER_SAVE", paramString);
  }
  
  public void c(String paramString)
  {
    bnzb.b("AEEditorManagerForQzone", "[retry]");
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), PeakService.class);
    localIntent.putExtra("ServiceAction", 4);
    localIntent.putExtra("generate_mission", paramString);
    BaseApplicationImpl.getApplication().startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhv
 * JD-Core Version:    0.7.0.1
 */