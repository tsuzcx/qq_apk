import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.camera.core.AEEditorGenerateBroadcastReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class bksw
  implements bksv
{
  private AEEditorGenerateBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorGenerateBroadcastReceiver = new AEEditorGenerateBroadcastReceiver(this);
  private final String jdField_a_of_type_JavaLangString = "AEEditorManagerForQzone";
  private List<bksy> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<String, LocalMediaInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public static bksw a()
  {
    return bksz.a;
  }
  
  private void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      bljn.d("AEEditorManagerForQzone", "[sendBroadCast] action or missionID is null");
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
    bljn.b("AEEditorManagerForQzone", "[init]");
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorGenerateBroadcastReceiver.a(BaseApplicationImpl.getContext());
  }
  
  public void a(@Nullable bksy parambksy)
  {
    bljn.b("AEEditorManagerForQzone", "[addListener]");
    if ((parambksy != null) && (!this.jdField_a_of_type_JavaUtilList.contains(parambksy))) {
      this.jdField_a_of_type_JavaUtilList.add(parambksy);
    }
  }
  
  public void a(@NonNull String paramString)
  {
    bljn.b("AEEditorManagerForQzone", "[cancel]");
    a("AEEDITOR_ORDER_CANCEL", paramString);
  }
  
  public void a(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bljn.d("AEEditorManagerForQzone", "[onAETavSessionExporting] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null)
    {
      localObject = blpx.a(0, 0, null, null, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bksy)((Iterator)localObject).next()).onAETavSessionExporting(paramString, paramFloat);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bljn.d("AEEditorManagerForQzone", "[onAETavSessionExportError] mission is null");
      return;
    }
    Object localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null)
    {
      localObject = blpx.a(0, 0, null, null, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bksy)((Iterator)localObject).next()).onAETavSessionExportError(paramString, paramInt);
      }
      break;
      ((LocalMediaInfo)localObject).isVideoReady = false;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      bljn.d("AEEditorManagerForQzone", "[onAETavSessionExportCompleted] mission is null");
    }
    for (;;)
    {
      return;
      paramString2 = blpx.a(paramString2, paramString3);
      if (paramString2 == null)
      {
        a(paramString1, -4);
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
      paramString3 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString3.hasNext()) {
        ((bksy)paramString3.next()).onAETavSessionExportCompleted(paramString1, paramString2);
      }
    }
  }
  
  public void b(@Nullable bksy parambksy)
  {
    bljn.b("AEEditorManagerForQzone", "[removeListener]");
    if ((parambksy != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambksy))) {
      this.jdField_a_of_type_JavaUtilList.remove(parambksy);
    }
  }
  
  public void b(String paramString)
  {
    bljn.b("AEEditorManagerForQzone", "[save]");
    a("AEEDITOR_ORDER_SAVE", paramString);
  }
  
  public void c(String paramString)
  {
    bljn.b("AEEditorManagerForQzone", "[retry]");
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), PeakService.class);
    localIntent.putExtra("ServiceAction", 4);
    localIntent.putExtra("generate_mission", paramString);
    BaseApplicationImpl.getApplication().startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksw
 * JD-Core Version:    0.7.0.1
 */