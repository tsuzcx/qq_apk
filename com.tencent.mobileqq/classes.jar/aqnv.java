import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqnv
{
  private aqol jdField_a_of_type_Aqol;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aqnv() {}
  
  public aqnv(aqol paramaqol)
  {
    this.jdField_a_of_type_Aqol = paramaqol;
  }
  
  public aqnv(QQAppInterface paramQQAppInterface, aqol paramaqol)
  {
    this(paramaqol);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
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
    String str = String.valueOf(paramInt1) + paramString + paramInt2;
    Object localObject;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNote~~~ key " + str);
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      aqol localaqol = a((QQAppInterface)localObject);
      paramString = null;
      if (localaqol != null) {
        paramString = localaqol.a(str);
      }
      if (paramString != null)
      {
        if (paramBoolean)
        {
          paramInt1 = i;
          paramString.setState(paramInt1);
        }
      }
      else
      {
        if (paramString == null) {
          break label223;
        }
        paramBoolean = true;
        label147:
        localBundle.putBoolean("extra_is_colornote_exists", paramBoolean);
        localBundle.putBoolean("extra_can_add_colornote", b());
        localBundle.putBoolean("extra_after_sync_msg", aqrl.a());
        paramString = aqrl.a((QQAppInterface)localObject);
        localBundle.putInt("key_float_window_position_x", paramString.x);
        localBundle.putInt("key_float_window_position_y", paramString.y);
        aqrl.a(((QQAppInterface)localObject).getApp(), 3, true);
        paramString = localBundle;
      }
    }
    label223:
    do
    {
      return paramString;
      paramInt1 = 1;
      break;
      paramBoolean = false;
      break label147;
      localObject = new Bundle();
      ((Bundle)localObject).putString("extra_unikey", str);
      ((Bundle)localObject).putBoolean("extra_update_colornote_state", paramBoolean);
      paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote_state", (Bundle)localObject);
      if ((paramString == null) || (!paramString.isSuccess())) {
        break label325;
      }
      localBundle = paramString.data;
      paramString = localBundle;
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteHelper", 2, "receive from ipc server: " + localObject);
    return localBundle;
    label325:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString != null) {
        break label370;
      }
    }
    label370:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return localBundle;
    }
  }
  
  private static aqol a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return null;
      paramQQAppInterface = paramQQAppInterface.getProxyManager();
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.a();
  }
  
  private EIPCResult a(String paramString1, String paramString2, Bundle paramBundle)
  {
    paramString2 = QIPCClientHelper.getInstance().getClient().callServer(paramString1, paramString2, paramBundle);
    if (((paramString2 == null) || (paramString2.isSuccess())) && (QLog.isColorLevel()))
    {
      paramBundle = new StringBuilder().append("addColorNote eipcResult = ");
      if (paramString2 != null) {
        break label66;
      }
    }
    label66:
    for (paramString1 = "null";; paramString1 = Boolean.valueOf(paramString2.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString1);
      return paramString2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ProxyListener paramProxyListener)
  {
    aqol localaqol = a(paramQQAppInterface);
    ArrayList localArrayList = null;
    if (localaqol != null) {
      localArrayList = localaqol.a(paramQQAppInterface.getCurrentAccountUin(), paramProxyListener);
    }
    aqnz.a(localArrayList);
  }
  
  protected static void a(String paramString, int paramInt)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = a((QQAppInterface)localObject2);
    if (localObject1 != null) {}
    for (paramString = ((aqol)localObject1).a(paramString, paramInt);; paramString = null)
    {
      if (paramString == null) {}
      do
      {
        return;
        ((aqol)localObject1).a(((QQAppInterface)localObject2).getCurrentUin(), paramString, null);
        aqrl.a(((QQAppInterface)localObject2).getApp(), 3, false);
        localObject2 = paramString.getServiceType() + "";
        String str = paramString.getSubType();
        Intent localIntent = new Intent("key_delete_item_call");
        localIntent.putExtra("key_color_note_servicetype_list", new String[] { localObject2 });
        localIntent.putExtra("key_color_note_suptype_list", new String[] { str });
        localIntent.putExtra("extra_can_add_colornote", ((aqol)localObject1).a());
        localIntent.putExtras(paramString.parseBundle());
        BaseApplicationImpl.getContext().sendBroadcast(localIntent);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(paramString);
        aqnz.a((ArrayList)localObject1);
      } while ((paramString == null) || (paramString.getServiceType() != 16908290));
      tkj.a(paramString);
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localObject = a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      if ((localObject != null) && (((aqol)localObject).a())) {
        bool = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool;
        bool = false;
      }
      localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_can_add_colornote", null);
      if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
        return ((EIPCResult)localObject).data.getBoolean("extra_can_add_colornote", true);
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("deleteColorNote eipcResult = ");
    if (localObject == null) {}
    for (Object localObject = "null";; localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, localObject);
      return false;
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      aqqf.a(paramInt);
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
      localObject = a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      if (localObject == null) {
        break label287;
      }
      localObject = ((aqol)localObject).a(false).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ColorNote)((Iterator)localObject).next()).getUniKey().equals(paramString));
    }
    label287:
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
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Aqol == null)
      {
        paramQQAppInterface = paramQQAppInterface.getProxyManager();
        if (paramQQAppInterface != null) {
          this.jdField_a_of_type_Aqol = paramQQAppInterface.a();
        }
      }
    } while (this.jdField_a_of_type_Aqol == null);
    return true;
  }
  
  public static boolean a(ColorNote paramColorNote)
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return d(paramColorNote);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("color_note_recently_viewed_comparator", paramColorNote);
    return QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_color_note", localBundle).isSuccess();
  }
  
  public static boolean a(String paramString1, String paramString2, Object paramObject)
  {
    return a(paramString1, paramString2, paramObject, 0);
  }
  
  public static boolean a(String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "updateColorNote~~~");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNote~~~ main[ uniKey = " + paramString1 + ", fieldName = " + paramString2 + ", fieldValue = " + paramObject + "]");
      }
      return b(paramString1, paramString2, paramObject);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_unikey", paramString1);
    localBundle.putString("extra_field_name", paramString2);
    if (paramInt == 0) {
      localBundle.putString("extra_field_value", (String)paramObject);
    }
    for (;;)
    {
      paramString1 = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote", localBundle);
      if ((paramString1 == null) || (!paramString1.isSuccess())) {
        break;
      }
      return paramString1.data.getBoolean("extra_update_colornote_succ", false);
      if (paramInt == 1) {
        localBundle.putByteArray("extra_field_value", (byte[])paramObject);
      }
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString1 != null) {
        break label233;
      }
    }
    label233:
    for (paramString1 = "null";; paramString1 = Boolean.valueOf(paramString1.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString1);
      return false;
    }
  }
  
  private boolean a(String paramString, List<ColorNote> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ColorNote)paramList.next()).getUniKey().equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  protected static boolean b()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      aqol localaqol = a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      if ((localaqol != null) && (localaqol.a())) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ColorNoteHelper", 2, "[canAddColorNoteInner] noteProxy: " + localaqol);
          if (localaqol != null) {
            QLog.d("ColorNoteHelper", 2, "[canAddColorNoteInner] canAddColorNote: " + localaqol);
          }
        }
        return bool;
      }
    }
    return false;
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
  
  protected static boolean b(String paramString1, String paramString2, Object paramObject)
  {
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      aqol localaqol = a(localQQAppInterface);
      if (localaqol != null)
      {
        paramString2 = localaqol.a(localQQAppInterface.getCurrentUin(), paramString1, paramString2, paramObject);
        if (paramString2 != null) {
          bool = true;
        }
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
      paramString2 = null;
      break;
      bool = false;
    }
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteHelper", 1, "mApp init failed", localException);
      }
    }
    return false;
  }
  
  private static boolean d(ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aqol localaqol = a(localQQAppInterface);
    if (localaqol == null) {
      return false;
    }
    aqrl.a(localQQAppInterface.getApp(), true, false);
    return localaqol.a(localQQAppInterface.getCurrentUin(), paramColorNote);
  }
  
  private boolean e()
  {
    if (!d())
    {
      QLog.e("ColorNoteHelper", 1, "[_updateColorNoteState] app is null" + aqoq.a());
      return false;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.e("ColorNoteHelper", 1, "[_updateColorNoteState] proxy is null" + aqoq.a());
      return false;
    }
    return true;
  }
  
  private boolean e(ColorNote paramColorNote)
  {
    if (!e())
    {
      QLog.e("ColorNoteHelper", 1, "[addColorNoteAux] app or proxy is null");
      return false;
    }
    if (paramColorNote.mExtra == 2) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = this.jdField_a_of_type_Aqol;
      paramColorNote.animate = true;
      boolean bool1;
      if ((((aqol)localObject).a()) || (i != 0) || (paramColorNote.getServiceType() == 16973824))
      {
        bool1 = ((aqol)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramColorNote, null, false);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ " + paramColorNote);
        }
        if (paramColorNote.mExtra != 2)
        {
          localObject = bhhr.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          boolean bool2 = ((SharedPreferences)localObject).getBoolean("color_note_permission_music", true);
          if (paramColorNote.mServiceType == 16973824)
          {
            i = 1;
            if ((i != 0) && (!bool2)) {
              break label229;
            }
          }
          label229:
          for (int j = 1;; j = 0)
          {
            if (j != 0)
            {
              aqrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), true, false, paramColorNote);
              if (i != 0) {
                ((SharedPreferences)localObject).edit().putBoolean("color_note_permission_music", false).apply();
              }
            }
            if (i != 0) {
              aqrl.a(BaseApplicationImpl.getContext());
            }
            return bool1;
            i = 0;
            break;
          }
        }
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ fail cause count limit, maxCount = " + aqol.a + " , currCount = " + ((aqol)localObject).a());
        return false;
      }
      return bool1;
    }
  }
  
  private boolean f()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public Bundle a(String paramString, boolean paramBoolean)
  {
    int i = 2;
    Bundle localBundle = new Bundle();
    if (f())
    {
      if (!e())
      {
        QLog.e("ColorNoteHelper", 1, "[_updateColorNoteState] app or proxy is null");
        return null;
      }
      paramString = this.jdField_a_of_type_Aqol.a(paramString);
      if (paramString != null)
      {
        if (paramBoolean) {
          paramString.setState(i);
        }
      }
      else {
        if (paramString == null) {
          break label143;
        }
      }
      label143:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localBundle.putBoolean("extra_is_colornote_exists", paramBoolean);
        localBundle.putBoolean("extra_can_add_colornote", c());
        localBundle.putBoolean("extra_after_sync_msg", aqrl.a());
        paramString = aqrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localBundle.putInt("key_float_window_position_x", paramString.x);
        localBundle.putInt("key_float_window_position_y", paramString.y);
        aqrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 3, true);
        return localBundle;
        i = 1;
        break;
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    ((Bundle)localObject).putBoolean("extra_update_colornote_state", paramBoolean);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote_state", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess()))
    {
      paramString = paramString.data;
      if (QLog.isColorLevel())
      {
        QLog.d("ColorNoteHelper", 2, "[_updateColorNoteState] call server result: " + paramString);
        return paramString;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("updateColorNote eipcResult = ");
        if (paramString != null) {
          break label284;
        }
      }
      label284:
      for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
      {
        QLog.d("ColorNoteHelper", 2, paramString);
        return localBundle;
      }
    }
    return paramString;
  }
  
  public void a(aqol paramaqol)
  {
    this.jdField_a_of_type_Aqol = paramaqol;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (f()) {
      return e(new ColorNote(paramBundle));
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
        break label101;
      }
    }
    label101:
    for (paramBundle = "null";; paramBundle = Boolean.valueOf(paramBundle.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramBundle);
      return false;
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "start search. key: " + paramString);
    }
    if (f()) {
      if (this.jdField_a_of_type_Aqol == null) {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHelper", 2, "ColorNoteProxy is null");
        }
      }
    }
    do
    {
      return false;
      return a(paramString, this.jdField_a_of_type_Aqol.a(false));
      Bundle localBundle = new Bundle();
      localBundle.putString("extra_unikey", paramString);
      paramString = a("ColorNoteIPCServer", "cmd_query_isexists", localBundle);
    } while (paramString == null);
    return paramString.data.getBoolean("extra_is_colornote_exists", false);
  }
  
  boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Aqol == null) || (StringUtil.isEmpty(paramString))) {}
    do
    {
      return false;
      paramString = this.jdField_a_of_type_Aqol.a(paramString, paramInt);
    } while (paramString == null);
    this.jdField_a_of_type_Aqol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString, null);
    aqrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 3, false);
    Object localObject = paramString.getServiceType() + "";
    String str = paramString.getSubType();
    Intent localIntent = new Intent("key_delete_item_call");
    localIntent.putExtra("key_color_note_servicetype_list", new String[] { localObject });
    localIntent.putExtra("key_color_note_suptype_list", new String[] { str });
    localIntent.putExtra("extra_can_add_colornote", this.jdField_a_of_type_Aqol.a());
    localIntent.putExtras(paramString.parseBundle());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    aqnz.a((ArrayList)localObject);
    return true;
  }
  
  boolean b(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Aqol == null) {
      return false;
    }
    aqrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), true, false, paramColorNote);
    return this.jdField_a_of_type_Aqol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramColorNote);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "deleteColorNote~~~ main key" + paramString);
      }
      a(paramString, paramInt);
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    ((Bundle)localObject).putInt("color_note_extra_type", paramInt);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_delete_colornote", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getBoolean("extra_delete_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("deleteColorNote eipcResult = ");
      if (paramString != null) {
        break label153;
      }
    }
    label153:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return false;
    }
  }
  
  public boolean b(String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if (f()) {
      return c(paramString1, paramString2, paramObject);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_unikey", paramString1);
    localBundle.putString("extra_field_name", paramString2);
    if (paramInt == 0) {
      localBundle.putString("extra_field_value", (String)paramObject);
    }
    for (;;)
    {
      paramString1 = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote", localBundle);
      if ((paramString1 == null) || (!paramString1.isSuccess())) {
        break;
      }
      return paramString1.data.getBoolean("extra_update_colornote_succ", false);
      if (paramInt == 1) {
        localBundle.putByteArray("extra_field_value", (byte[])paramObject);
      }
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString1 != null) {
        break label164;
      }
    }
    label164:
    for (paramString1 = "null";; paramString1 = Boolean.valueOf(paramString1.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString1);
      return false;
    }
  }
  
  public boolean c()
  {
    if (f()) {
      if (!e())
      {
        QLog.e("ColorNoteHelper", 1, "[_canAddColorNote] app or proxy is null");
        return false;
      }
    }
    for (boolean bool = this.jdField_a_of_type_Aqol.a();; bool = ((EIPCResult)localObject).data.getBoolean("extra_can_add_colornote", true))
    {
      return bool;
      localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_can_add_colornote", null);
      if ((localObject == null) || (!((EIPCResult)localObject).isSuccess())) {
        break;
      }
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("deleteColorNote eipcResult = ");
      if (localObject != null) {
        break label122;
      }
    }
    label122:
    for (Object localObject = "null";; localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, localObject);
      bool = false;
      break;
    }
  }
  
  public boolean c(ColorNote paramColorNote)
  {
    if (f()) {
      return b(paramColorNote);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("color_note_recently_viewed_comparator", paramColorNote);
    return QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_color_note", localBundle).isSuccess();
  }
  
  public boolean c(String paramString1, String paramString2, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Aqol != null) {
        break label31;
      }
      bool2 = bool1;
    }
    label31:
    do
    {
      return bool2;
      bool1 = bool3;
      if (f())
      {
        bool1 = bool3;
        if (this.jdField_a_of_type_Aqol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString1, paramString2, paramObject) != null) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteHelper", 2, "updateColorNoteInner~~~ unikey " + paramString1 + ", result" + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnv
 * JD-Core Version:    0.7.0.1
 */