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

public class aoca
{
  private aoco jdField_a_of_type_Aoco;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aoca() {}
  
  public aoca(aoco paramaoco)
  {
    this.jdField_a_of_type_Aoco = paramaoco;
  }
  
  public aoca(QQAppInterface paramQQAppInterface, aoco paramaoco)
  {
    this(paramaoco);
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
        localBundle.putBoolean("extra_after_sync_msg", aofm.a());
        localObject = aofm.a(paramString);
        localBundle.putInt("key_float_window_position_x", ((Point)localObject).x);
        localBundle.putInt("key_float_window_position_y", ((Point)localObject).y);
        aofm.a(paramString.getApp(), 3, true);
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
  
  public static void a(QQAppInterface paramQQAppInterface, amnx paramamnx)
  {
    aoce.a(paramQQAppInterface.a().a().a(paramQQAppInterface.getCurrentAccountUin(), paramamnx));
  }
  
  private void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.e("ColorNoteHelper", 1, "app null");
        return;
      }
    }
    Object localObject;
    if (this.jdField_a_of_type_Aoco == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null) {
        this.jdField_a_of_type_Aoco = ((ProxyManager)localObject).a();
      }
      if (this.jdField_a_of_type_Aoco == null)
      {
        QLog.e("ColorNoteHelper", 1, "proxy null");
        return;
      }
    }
    if (paramColorNote.mExtra == 2) {}
    for (int i = 1;; i = 0)
    {
      localObject = this.jdField_a_of_type_Aoco;
      paramColorNote.animate = true;
      if ((((aoco)localObject).a()) || (i != 0) || (paramColorNote.getServiceType() == 16973824))
      {
        ((aoco)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramColorNote, null, false);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ " + paramColorNote);
        }
        if (paramColorNote.mExtra == 2) {
          break;
        }
        localObject = bdne.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        boolean bool = ((SharedPreferences)localObject).getBoolean("color_note_permission_music", true);
        if (paramColorNote.mServiceType == 16973824)
        {
          i = 1;
          label216:
          if ((i != 0) && (!bool)) {
            break label283;
          }
        }
        label283:
        for (int j = 1;; j = 0)
        {
          if (j != 0)
          {
            aofm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), true, false);
            if (i != 0) {
              ((SharedPreferences)localObject).edit().putBoolean("color_note_permission_music", false).apply();
            }
          }
          if (i == 0) {
            break;
          }
          aofm.a(BaseApplicationImpl.getContext());
          return;
          i = 0;
          break label216;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ fail cause count limit, maxCount = " + aoco.a + " , currCount = " + ((aoco)localObject).a());
      return;
    }
  }
  
  protected static void a(String paramString, int paramInt)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = ((QQAppInterface)localObject2).a().a();
    paramString = ((aoco)localObject1).a(paramString, paramInt);
    if (paramString == null) {}
    do
    {
      return;
      ((aoco)localObject1).a(((QQAppInterface)localObject2).c(), paramString, null);
      aofm.a(((QQAppInterface)localObject2).getApp(), 3, false);
      localObject2 = paramString.getServiceType() + "";
      String str = paramString.getSubType();
      Intent localIntent = new Intent("key_delete_item_call");
      localIntent.putExtra("key_color_note_servicetype_list", new String[] { localObject2 });
      localIntent.putExtra("key_color_note_suptype_list", new String[] { str });
      localIntent.putExtra("extra_can_add_colornote", ((aoco)localObject1).a());
      localIntent.putExtras(paramString.parseBundle());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramString);
      aoce.a((ArrayList)localObject1);
    } while ((paramString == null) || (paramString.getServiceType() != 16908290));
    sdn.a(paramString);
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
      aoee.a(paramInt);
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
  
  public static boolean a(ColorNote paramColorNote)
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return d(paramColorNote);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("color_note_recently_viewed_comparator", paramColorNote);
    return QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_color_note", localBundle).isSuccess();
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
  
  private boolean d()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  private static boolean d(ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aoco localaoco = localQQAppInterface.a().a();
    aofm.a(localQQAppInterface.getApp(), true, false);
    return localaoco.a(localQQAppInterface.c(), paramColorNote);
  }
  
  public Bundle a(String paramString, boolean paramBoolean)
  {
    int i = 2;
    Bundle localBundle = new Bundle();
    if (d())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Aoco == null)) {
        return null;
      }
      paramString = this.jdField_a_of_type_Aoco.a(paramString);
      if (paramString != null)
      {
        if (paramBoolean) {
          paramString.setState(i);
        }
      }
      else {
        if (paramString == null) {
          break label141;
        }
      }
      label141:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localBundle.putBoolean("extra_is_colornote_exists", paramBoolean);
        localBundle.putBoolean("extra_can_add_colornote", c());
        localBundle.putBoolean("extra_after_sync_msg", aofm.a());
        paramString = aofm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localBundle.putInt("key_float_window_position_x", paramString.x);
        localBundle.putInt("key_float_window_position_y", paramString.y);
        aofm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 3, true);
        return localBundle;
        i = 1;
        break;
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    ((Bundle)localObject).putBoolean("extra_update_colornote_state", paramBoolean);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote_state", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString != null) {
        break label248;
      }
    }
    label248:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return localBundle;
    }
  }
  
  public void a(aoco paramaoco)
  {
    this.jdField_a_of_type_Aoco = paramaoco;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (d())
    {
      a(new ColorNote(paramBundle));
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
        break label102;
      }
    }
    label102:
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
    if (d())
    {
      if (this.jdField_a_of_type_Aoco == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHelper", 2, "ColorNoteProxy is null");
        }
        return false;
      }
      return a(paramString, this.jdField_a_of_type_Aoco.a(false));
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_unikey", paramString);
    return a("ColorNoteIPCServer", "cmd_query_isexists", localBundle).data.getBoolean("extra_is_colornote_exists", false);
  }
  
  boolean a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Aoco == null) || (bdnn.a(paramString))) {}
    do
    {
      return false;
      paramString = this.jdField_a_of_type_Aoco.a(paramString, paramInt);
    } while (paramString == null);
    this.jdField_a_of_type_Aoco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString, null);
    aofm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 3, false);
    Object localObject = paramString.getServiceType() + "";
    String str = paramString.getSubType();
    Intent localIntent = new Intent("key_delete_item_call");
    localIntent.putExtra("key_color_note_servicetype_list", new String[] { localObject });
    localIntent.putExtra("key_color_note_suptype_list", new String[] { str });
    localIntent.putExtra("extra_can_add_colornote", this.jdField_a_of_type_Aoco.a());
    localIntent.putExtras(paramString.parseBundle());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    aoce.a((ArrayList)localObject);
    if ((paramString != null) && (paramString.getServiceType() == 16908290)) {
      sdn.a(paramString);
    }
    return true;
  }
  
  boolean b(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_Aoco == null) {
      return false;
    }
    aofm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), true, false);
    return this.jdField_a_of_type_Aoco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramColorNote);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (d())
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
  
  public boolean b(String paramString1, String paramString2, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Aoco != null) {
        break label31;
      }
      bool2 = bool1;
    }
    label31:
    do
    {
      return bool2;
      bool1 = bool3;
      if (d())
      {
        bool1 = bool3;
        if (this.jdField_a_of_type_Aoco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString1, paramString2, paramObject) != null) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteHelper", 2, "updateColorNoteInner~~~ unikey " + paramString1 + ", result" + bool1);
    return bool1;
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (d()) {
      return b(paramString1, paramString2, paramString3);
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
        break label132;
      }
    }
    label132:
    for (paramString1 = "null";; paramString1 = Boolean.valueOf(paramString1.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString1);
      return false;
    }
  }
  
  public boolean c()
  {
    if (d()) {
      return this.jdField_a_of_type_Aoco.a();
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
        break label96;
      }
    }
    label96:
    for (localObject = "null";; localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, localObject);
      return false;
    }
  }
  
  public boolean c(ColorNote paramColorNote)
  {
    if (d()) {
      return b(paramColorNote);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("color_note_recently_viewed_comparator", paramColorNote);
    return QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_color_note", localBundle).isSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoca
 * JD-Core Version:    0.7.0.1
 */