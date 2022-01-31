import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amgr
{
  public static Bundle a(int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramInt, paramString, paramBoolean, 0);
  }
  
  public static Bundle a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "updateColorNote~~~");
    }
    Bundle localBundle = new Bundle();
    Object localObject = String.valueOf(paramInt1) + paramString + paramInt2;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNote~~~ key " + (String)localObject);
      }
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = paramString.a().a().a((String)localObject);
      if (localObject != null)
      {
        if (paramBoolean)
        {
          paramInt1 = i;
          ((ColorNote)localObject).setState(paramInt1);
        }
      }
      else {
        if (localObject == null) {
          break label216;
        }
      }
      label216:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localBundle.putBoolean("extra_is_colornote_exists", paramBoolean);
        localBundle.putBoolean("extra_can_add_colornote", b());
        localBundle.putBoolean("extra_after_sync_msg", amkf.a());
        localObject = amkf.a(paramString);
        localBundle.putInt("key_float_window_position_x", ((Point)localObject).x);
        localBundle.putInt("key_float_window_position_y", ((Point)localObject).y);
        amkf.a(paramString.getApp(), 3, true);
        return localBundle;
        paramInt1 = 1;
        break;
      }
    }
    paramString = new Bundle();
    paramString.putString("extra_unikey", (String)localObject);
    paramString.putBoolean("extra_update_colornote_state", paramBoolean);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote_state", paramString);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString != null) {
        break label320;
      }
    }
    label320:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return localBundle;
    }
  }
  
  protected static Bundle a(String paramString, boolean paramBoolean)
  {
    int i = 2;
    Bundle localBundle = new Bundle();
    QQAppInterface localQQAppInterface;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNoteInner~~~ unikey " + paramString);
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramString = localQQAppInterface.a().a().a(paramString);
      if (paramString != null)
      {
        if (!paramBoolean) {
          break label154;
        }
        paramString.setState(i);
      }
      if (paramString == null) {
        break label159;
      }
    }
    label154:
    label159:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localBundle.putBoolean("extra_is_colornote_exists", paramBoolean);
      localBundle.putBoolean("extra_can_add_colornote", b());
      localBundle.putBoolean("extra_after_sync_msg", amkf.a());
      paramString = amkf.a(localQQAppInterface);
      localBundle.putInt("key_float_window_position_x", paramString.x);
      localBundle.putInt("key_float_window_position_y", paramString.y);
      amkf.a(localQQAppInterface.getApp(), 3, true);
      return localBundle;
      i = 1;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aktd paramaktd)
  {
    amgu.a(paramQQAppInterface.a().a().a(paramQQAppInterface.getCurrentAccountUin(), paramaktd));
  }
  
  private static void a(ColorNote paramColorNote)
  {
    if (paramColorNote.mExtra == 2) {}
    for (int i = 1;; i = 0)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = localQQAppInterface.a().a();
      paramColorNote.animate = true;
      if ((((amhe)localObject).a()) || (i != 0) || (paramColorNote.getServiceType() == 16973824))
      {
        ((amhe)localObject).a(localQQAppInterface.c(), paramColorNote, null, false);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ " + paramColorNote);
        }
        if (paramColorNote.mExtra != 2)
        {
          localObject = bbkb.a(BaseApplicationImpl.getContext(), localQQAppInterface.c());
          bool = ((SharedPreferences)localObject).getBoolean("color_note_permission_music", true);
          if (paramColorNote.mServiceType != 16973824) {
            break label203;
          }
          i = 1;
          if ((i != 0) && (!bool)) {
            break label208;
          }
          j = 1;
          if (j != 0)
          {
            amkf.a(localQQAppInterface.getApp(), true, false);
            if (i != 0) {
              ((SharedPreferences)localObject).edit().putBoolean("color_note_permission_music", false).apply();
            }
          }
          if (i != 0) {
            amkf.a(BaseApplicationImpl.getContext());
          }
        }
      }
      label203:
      label208:
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          boolean bool;
          return;
          i = 0;
          continue;
          int j = 0;
        }
      }
      QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ fail cause count limit, maxCount = " + amhe.a + " , currCount = " + ((amhe)localObject).a());
      return;
    }
  }
  
  protected static void a(String paramString, int paramInt)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = ((QQAppInterface)localObject2).a().a();
    paramString = ((amhe)localObject1).a(paramString, paramInt);
    if (paramString == null) {}
    do
    {
      return;
      ((amhe)localObject1).c(((QQAppInterface)localObject2).c(), paramString, null);
      amkf.a(((QQAppInterface)localObject2).getApp(), 3, false);
      localObject2 = paramString.getServiceType() + "";
      String str = paramString.getSubType();
      Intent localIntent = new Intent("key_delete_item_call");
      localIntent.putExtra("key_color_note_servicetype_list", new String[] { localObject2 });
      localIntent.putExtra("key_color_note_suptype_list", new String[] { str });
      localIntent.putExtra("extra_can_add_colornote", ((amhe)localObject1).a());
      localIntent.putExtras(paramString.parseBundle());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramString);
      amgu.a((ArrayList)localObject1);
    } while ((paramString == null) || (paramString.getServiceType() != 16908290));
    rno.a(paramString);
  }
  
  public static boolean a()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a();
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_can_add_colornote", null);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("extra_can_add_colornote", false);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("deleteColorNote eipcResult = ");
      if (localObject != null) {
        break label107;
      }
    }
    label107:
    for (localObject = "null";; localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, localObject);
      return false;
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      amiu.a(paramInt);
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("color_note_service_type", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_history_color_notes", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("extra_clear_history_succ", false);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("clearHistoryNote eipcResult = ");
      if (localObject != null) {
        break label112;
      }
    }
    label112:
    for (localObject = "null";; localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, localObject);
      return false;
    }
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, 0);
  }
  
  public static boolean a(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "isColorNoteExit~~~ serviceType = " + paramInt1 + ", subType = " + paramString);
    }
    paramString = String.valueOf(paramInt1) + paramString + paramInt2;
    Object localObject;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localObject = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a(false).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ColorNote)((Iterator)localObject).next()).getUniKey().equals(paramString));
    }
    for (bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "isColorNoteExit main ~~~ result = " + bool);
      }
      do
      {
        return bool;
        localObject = new Bundle();
        ((Bundle)localObject).putString("extra_unikey", paramString);
        paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_query_isexists", (Bundle)localObject);
        if ((paramString != null) && (paramString.isSuccess())) {
          return paramString.data.getBoolean("extra_is_colornote_exists", false);
        }
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("isColorNoteExit eipcResult = ");
      if (paramString == null) {}
      for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
      {
        QLog.d("ColorNoteHelper", 2, paramString);
        return false;
      }
    }
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "addColorNote~~~");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      paramBundle = new ColorNote(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "addColorNote~~~ main " + paramBundle.toString());
      }
      a(paramBundle);
      return true;
    }
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_add_colornote", paramBundle);
    if ((paramBundle != null) && (paramBundle.isSuccess())) {
      return paramBundle.data.getBoolean("extra_add_colornote_succ", false);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("addColorNote eipcResult = ");
      if (paramBundle != null) {
        break label154;
      }
    }
    label154:
    for (paramBundle = "null";; paramBundle = Boolean.valueOf(paramBundle.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramBundle);
      return false;
    }
  }
  
  public static boolean a(ColorNote paramColorNote)
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return b(paramColorNote);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("color_note_recently_viewed_comparator", paramColorNote);
    return QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_color_note", localBundle).isSuccess();
  }
  
  protected static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "isColorNoteExitInner");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Iterator localIterator = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a(false).iterator();
      while (localIterator.hasNext()) {
        if (((ColorNote)localIterator.next()).getUniKey().equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected static boolean a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "deleteColorNoteInner");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "deleteColorNote~~~ main key" + paramString);
      }
      a(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  protected static boolean a(String paramString1, String paramString2, Object paramObject)
  {
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface.a().a().a(localQQAppInterface.c(), paramString1, paramString2, paramObject) != null) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNoteInner~~~ unikey " + paramString1 + ", result" + bool);
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "updateColorNote~~~");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNote~~~ main[ uniKey = " + paramString1 + ", fieldName = " + paramString2 + ", fieldValue = " + paramString3 + "]");
      }
      return a(paramString1, paramString2, paramString3);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_unikey", paramString1);
    localBundle.putString("extra_field_name", paramString2);
    localBundle.putString("extra_field_value", paramString3);
    paramString1 = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote", localBundle);
    if ((paramString1 != null) && (paramString1.isSuccess())) {
      return paramString1.data.getBoolean("extra_update_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString1 != null) {
        break label198;
      }
    }
    label198:
    for (paramString1 = "null";; paramString1 = Boolean.valueOf(paramString1.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString1);
      return false;
    }
  }
  
  protected static boolean b()
  {
    return (BaseApplicationImpl.sProcessId == 1) && (((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a());
  }
  
  public static boolean b(int paramInt, String paramString)
  {
    return b(paramInt, paramString, 0);
  }
  
  public static boolean b(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "deleteColorNote~~~");
    }
    paramString = String.valueOf(paramInt1) + paramString + paramInt2;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "deleteColorNote~~~ main key" + paramString);
      }
      a(paramString, paramInt2);
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    ((Bundle)localObject).putInt("color_note_extra_type", paramInt2);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_delete_colornote", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getBoolean("extra_delete_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("deleteColorNote eipcResult = ");
      if (paramString != null) {
        break label192;
      }
    }
    label192:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return false;
    }
  }
  
  protected static boolean b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "addColorNoteInner");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      paramBundle = new ColorNote(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ main " + paramBundle.toString());
      }
      a(paramBundle);
      return true;
    }
    return false;
  }
  
  private static boolean b(ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    amhe localamhe = localQQAppInterface.a().a();
    amkf.a(localQQAppInterface.getApp(), true, false);
    return localamhe.a(localQQAppInterface.c(), paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgr
 * JD-Core Version:    0.7.0.1
 */