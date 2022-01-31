import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class aoda
  implements aocw
{
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(Context paramContext, int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = paramContext.getString(2131692603);
    }
    QQToast.a(paramContext, 0, str, 0).a();
  }
  
  private void b(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      paramColorNote = new JSONObject(paramColorNote);
      long l1 = paramColorNote.getLong("file_color_note_uniSeq");
      long l2 = paramColorNote.getLong("file_color_note_sessionId");
      int i = paramColorNote.getInt("file_color_note_peerType");
      paramColorNote = paramColorNote.getString("file_color_note_peerUin");
      paramColorNote = ((QQAppInterface)localObject).a().a(l1, paramColorNote, i, l2);
      if (paramColorNote == null)
      {
        a(paramContext, 1);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    paramColorNote = new arlq((QQAppInterface)localObject, paramContext, paramColorNote, 10001);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("from_qlink_enter_recent", false);
    paramColorNote.a((Bundle)localObject);
    paramContext = new arls(paramContext, paramColorNote);
    paramContext.a(14);
    paramContext.b(268435456);
    paramContext.a();
  }
  
  private void c(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    long l;
    try
    {
      paramColorNote = new JSONObject(paramColorNote);
      paramColorNote.getInt("file_color_note_peerType");
      l = paramColorNote.getLong("file_color_note_peerUin");
      paramColorNote = bcnt.a(localQQAppInterface, l, paramColorNote.getString("file_color_note_file_uuid"), paramColorNote.getString("file_color_note_file_url"), paramColorNote.getString("file_color_note_fileName"), paramColorNote.getLong("file_color_note_fileSize"), paramColorNote.getInt("file_color_note_busId"));
      if (paramColorNote == null)
      {
        a(paramContext, 1);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramColorNote.b == 12)
    {
      a(paramContext, 1);
      return;
    }
    paramContext = new arls(paramContext, new arlw(localQQAppInterface, paramContext, l, paramColorNote, -1));
    paramContext.a(14);
    paramContext.a(TroopFileDetailBrowserActivity.class);
    paramContext.a(true);
    paramContext.b(268435456);
    paramContext.a();
  }
  
  private void d(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    String str = new String(paramColorNote.getReserve());
    try
    {
      str = new JSONObject(str).getString("file_color_note_local_path");
      if (!bdhb.b(str))
      {
        a(paramContext, 1);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    int i = arsx.a(paramColorNote.getSubType());
    paramColorNote = new arlq((QQAppInterface)localObject, paramContext, arrr.a(FileInfo.a(str)), 10000);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("file_color_note_subType", i);
    paramColorNote.a((Bundle)localObject);
    paramContext = new arls(paramContext, paramColorNote);
    paramContext.a(14);
    paramContext.b(268435456);
    paramContext.a();
  }
  
  private void e(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      long l = new JSONObject(paramColorNote).getLong("file_color_note_uniSeq");
      int i = DataLineMsgRecord.getDevTypeBySeId(l);
      paramColorNote = localQQAppInterface.a().a(i).a(l);
      if (paramColorNote != null)
      {
        paramContext = new arls(paramContext, new arlr(paramContext, arrr.a(paramColorNote)));
        paramContext.a(14);
        paramContext.b(268435456);
        paramContext.a();
        return;
      }
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    a(paramContext, 1);
  }
  
  private void f(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      JSONObject localJSONObject = new JSONObject(paramColorNote);
      long l = localJSONObject.getLong("file_color_note_sessionId");
      paramColorNote = ((QQAppInterface)localObject).a().a(l);
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.jdField_b_of_type_Long = localJSONObject.getLong("file_color_note_cloud_lastTime");
      localWeiYunFileInfo.jdField_a_of_type_Long = localJSONObject.getLong("file_color_note_fileSize");
      localWeiYunFileInfo.jdField_a_of_type_Int = localJSONObject.getInt("file_color_note_cloud_srcType");
      localWeiYunFileInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("file_color_note_cloud_fileId");
      localWeiYunFileInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("file_color_note_cloud_dirKey");
      localWeiYunFileInfo.c = localJSONObject.getString("file_color_note_fileName");
      if (localJSONObject.has("file_color_note_cloud_encodeUrl")) {
        localWeiYunFileInfo.e = localJSONObject.getString("file_color_note_cloud_encodeUrl");
      }
      if (localJSONObject.has("file_color_note_cloud_")) {
        localWeiYunFileInfo.i = localJSONObject.getString("file_color_note_cloud_");
      }
      if (localJSONObject.has("file_color_note_cloud_")) {
        localWeiYunFileInfo.j = localJSONObject.getString("file_color_note_cloud_");
      }
      localObject = new arlx((QQAppInterface)localObject, paramContext, localWeiYunFileInfo);
      ((arlx)localObject).a(paramColorNote);
      paramContext = new arls(paramContext, (arlv)localObject);
      paramContext.a(14);
      paramContext.b(268435456);
      paramContext.a();
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote.getServiceType() != 17039360) {}
    int i;
    do
    {
      return;
      if (TextUtils.isEmpty(paramColorNote.getSubType()))
      {
        QLog.i("QFileColorNoteLauncher", 1, "launch: subType is null.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFileColorNoteLauncher", 2, "launch: subKey[" + paramColorNote.getSubType() + "]");
      }
      i = arsx.a(paramColorNote.getSubType());
      if (i == -1)
      {
        QLog.i("QFileColorNoteLauncher", 1, "launch: subType is unknown.");
        return;
      }
    } while (paramColorNote.getReserve() == null);
    switch (i)
    {
    default: 
      return;
    case 1: 
      b(paramContext, paramColorNote);
      return;
    case 2: 
      c(paramContext, paramColorNote);
      return;
    case 5: 
      d(paramContext, paramColorNote);
      return;
    case 4: 
      d(paramContext, paramColorNote);
      return;
    case 6: 
      e(paramContext, paramColorNote);
      return;
    }
    f(paramContext, paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoda
 * JD-Core Version:    0.7.0.1
 */