package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectConfigBase.ItemBase;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.switchface.SwitchFaceMagicFaceDataEntity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class EffectFaceManager
  extends EffectConfigBase
  implements MagicfaceBaseDecoder.MagicPlayListener
{
  public static final String c = jdField_a_of_type_JavaLangString + 176 + File.separator;
  private MagicFaceDataEntity jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
  private MagicfaceBaseDecoder.MagicfaceRenderListener jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener;
  private MagicfacePlayer jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer = new MagicfacePlayer();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Queue jdField_a_of_type_JavaUtilQueue = new ArrayBlockingQueue(8);
  private String d;
  
  public EffectFaceManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private MagicFaceDataEntity a(FaceItem paramFaceItem, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str1;
    String str2;
    if (paramFaceItem != null)
    {
      AVLog.c("EffectFaceManager", String.format("createMagicEntity: id=%s, senderType%s.", new Object[] { paramFaceItem.getId(), Integer.valueOf(paramInt) }));
      str1 = paramFaceItem.getId();
      str2 = paramFaceItem.getType();
      if (!"multi_result".equalsIgnoreCase(paramFaceItem.getAttr())) {
        break label88;
      }
      localObject1 = new MagicFaceDataEntityMultiResult(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
    }
    label88:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while ("single".equalsIgnoreCase(paramFaceItem.getAttr()));
    if ("huanlian".equalsIgnoreCase(paramFaceItem.getAttr())) {
      return new SwitchFaceMagicFaceDataEntity(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
    }
    return new MagicFaceDataEntity(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
  }
  
  private MagicFaceDataEntity a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    paramString = (FaceItem)a(paramString);
    if (paramString != null)
    {
      Object localObject = b(paramString);
      localObject = new File((String)localObject + "config.json");
      if (((File)localObject).exists())
      {
        localObject = FileUtils.a((File)localObject);
        boolean bool;
        if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().a)
        {
          bool = true;
          if (!paramBoolean) {
            break label106;
          }
        }
        for (;;)
        {
          return a(paramString, (String)localObject, bool, i);
          bool = false;
          break;
          label106:
          i = 2;
        }
      }
      AVLog.e("EffectFaceManager", "prepareEntity FILE not exist: " + ((File)localObject).getPath());
    }
    return null;
  }
  
  private void a(MagicFaceDataEntity paramMagicFaceDataEntity, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = paramMagicFaceDataEntity;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null)
    {
      Object localObject = (FaceItem)a(paramMagicFaceDataEntity.b());
      if (localObject != null)
      {
        localObject = b((EffectConfigBase.ItemBase)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.a((String)localObject, paramMagicFaceDataEntity, paramMagicfaceRenderListener, this);
        }
      }
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 0)
    {
      MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)this.jdField_a_of_type_JavaUtilQueue.remove();
      a(localMagicFaceDataEntity, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener);
      b(localMagicFaceDataEntity.b());
      if (localMagicFaceDataEntity.c()) {
        a(Integer.valueOf(6102), this.d, Boolean.valueOf(false));
      }
      AVLog.c("EffectFaceManager", "restore : " + localMagicFaceDataEntity.b());
      return true;
    }
    return false;
  }
  
  private void c(String paramString)
  {
    paramString = (FaceItem)a(paramString);
    int i;
    if (paramString != null)
    {
      if (!paramString.isInteract()) {
        break label60;
      }
      i = 3;
      if (!paramString.isInteract()) {
        break label65;
      }
    }
    label60:
    label65:
    for (paramString = "START_" + paramString.getId();; paramString = paramString.getId())
    {
      b(i, paramString);
      return;
      i = 1;
      break;
    }
  }
  
  private void d(String paramString)
  {
    int j = 3;
    int i;
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      i = 3;
      if (!TextUtils.isEmpty(paramString)) {
        break label87;
      }
      str = "START_0";
      label22:
      paramString = (FaceItem)a(paramString);
      if (paramString == null) {
        break label107;
      }
      if (!paramString.isInteract()) {
        break label94;
      }
      i = j;
      label44:
      if (!paramString.isInteract()) {
        break label99;
      }
      paramString = "STOP_" + paramString.getId();
    }
    for (;;)
    {
      b(i, paramString);
      return;
      i = 1;
      break;
      label87:
      str = "0";
      break label22;
      label94:
      i = 1;
      break label44;
      label99:
      paramString = paramString.getId();
      continue;
      label107:
      paramString = str;
    }
  }
  
  public int a()
  {
    return 176;
  }
  
  public int a(int paramInt, String paramString)
  {
    AVLog.c("EffectFaceManager", "onReceivedMessageOfPeer : " + paramInt + "|" + paramString);
    String str1;
    if (paramInt == 3)
    {
      paramInt = paramString.indexOf('_');
      if (paramInt == -1) {
        return -1;
      }
      str1 = paramString.substring(0, paramInt);
      String str2 = paramString.substring(paramInt + 1, paramString.length());
      if ("START".equals(str1)) {
        if (!"0".equalsIgnoreCase(str2))
        {
          a(Integer.valueOf(6104), paramString, null);
          a(Integer.valueOf(6100), str2, Boolean.valueOf(false));
          a(Integer.valueOf(164), Integer.valueOf(0), null);
        }
      }
    }
    for (;;)
    {
      return 0;
      a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      continue;
      if ("STOP".equals(str1))
      {
        continue;
        if (paramInt == 1) {
          a(Integer.valueOf(6100), paramString, Boolean.valueOf(false));
        }
      }
    }
  }
  
  protected Class a()
  {
    return FaceItem.class;
  }
  
  public List a(String paramString)
  {
    List localList = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          FaceItem localFaceItem = (FaceItem)localList.get(i);
          if (paramString.equalsIgnoreCase(localFaceItem.getType())) {
            localArrayList.add(localFaceItem);
          }
          i += 1;
        }
      }
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      a(Integer.valueOf(6502), null, Boolean.valueOf(false));
      MagicDataReport.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      MagicDataReport.a(2, paramString1);
      MagicDataReport.a(2);
      return;
    }
    a(Integer.valueOf(6101), null, Boolean.valueOf(false));
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(168), paramMessage.obj });
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.c("EffectFaceManager", "notifyEvent :" + paramInteger + "|" + paramObject1);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    a(Integer.valueOf(165), Integer.valueOf(2), null);
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onEndMagicPlay : ").append(paramString).append("|");
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b())
    {
      AVLog.c("EffectFaceManager", (String)localObject);
      if ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b().equalsIgnoreCase(paramString)))
      {
        paramInt = this.jdField_a_of_type_JavaUtilQueue.size();
        if (paramInt >= 1)
        {
          localObject = (MagicFaceDataEntity)this.jdField_a_of_type_JavaUtilQueue.peek();
          boolean bool = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a((MagicfaceData)localObject);
          AVLog.c("EffectFaceManager", "onEndMagicPlay : " + paramString + "|" + paramInt + "|" + bool);
          if ((bool) && (paramInt < 8)) {
            this.jdField_a_of_type_JavaUtilQueue.add(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity);
          }
        }
      }
      if (!b())
      {
        a(Integer.valueOf(6101), null, Boolean.valueOf(false));
        if (!TextUtils.isEmpty(this.d))
        {
          ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).b(this.d);
          a(Integer.valueOf(6102), this.d, Boolean.valueOf(false));
        }
      }
      a(Integer.valueOf(165), Integer.valueOf(3), null);
      return;
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c))) {
      this.d = null;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a());
  }
  
  public boolean a(int paramInt, String paramString, boolean paramBoolean)
  {
    AVLog.c("EffectFaceManager", "stop face" + paramString + ", mStopType =" + paramBoolean);
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null)
    {
      String str = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b();
      if ((TextUtils.isEmpty(paramString)) || (str.equalsIgnoreCase(paramString)))
      {
        this.jdField_a_of_type_JavaUtilQueue.clear();
        AVLog.e("EffectFaceManager", "stop dequeue" + paramString);
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
        if (paramBoolean) {
          d(paramString);
        }
        if (TextUtils.isEmpty(paramString)) {
          b(null);
        }
        if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.a())
        {
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.b();
          AVLog.e("EffectFaceManager", "stop " + paramString + ", mStopType =" + paramInt);
        }
      }
    }
    return true;
  }
  
  public boolean a(FaceItem paramFaceItem)
  {
    boolean bool = super.a(paramFaceItem);
    if (bool) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase).sendToTarget();
    }
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilQueue.size() >= 8) || ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b()))))
    {
      paramMagicfaceRenderListener = new StringBuilder().append("start : ").append(paramString).append("|");
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity == null) {}
      for (paramString = "";; paramString = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b())
      {
        AVLog.e("EffectFaceManager", paramString + "|" + this.jdField_a_of_type_JavaUtilQueue.size());
        return false;
      }
    }
    AVLog.c("EffectFaceManager", "start : " + paramString + "|" + paramBoolean + "|" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.a());
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.a())
    {
      localObject = a(paramString, paramBoolean);
      if (localObject != null)
      {
        AVLog.c("EffectFaceManager", "start enqueue: " + paramString);
        this.jdField_a_of_type_JavaUtilQueue.add(localObject);
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfacePlayer.b();
      if (localObject != null)
      {
        b(paramString);
        if (!((MagicFaceDataEntity)localObject).b()) {
          break label369;
        }
        paramMagicfaceRenderListener = (EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
        localObject = (PendantItem)paramMagicfaceRenderListener.a();
        if ((localObject == null) || (!((PendantItem)localObject).isShow()) || (TextUtils.isEmpty(((PendantItem)localObject).getId()))) {
          break label361;
        }
        this.d = ((PendantItem)localObject).getId();
        paramMagicfaceRenderListener.b(null);
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        c(paramString);
      }
      return true;
      MagicFaceDataEntity localMagicFaceDataEntity = a(paramString, paramBoolean);
      localObject = localMagicFaceDataEntity;
      if (localMagicFaceDataEntity == null) {
        break;
      }
      a(localMagicFaceDataEntity, paramMagicfaceRenderListener);
      localObject = localMagicFaceDataEntity;
      break;
      label361:
      this.d = null;
      continue;
      label369:
      this.d = null;
    }
  }
  
  protected String b()
  {
    return "resources";
  }
  
  protected List b(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      if ((QLog.isColorLevel()) && (((JSONObject)localObject).has("version"))) {
        QLog.d("EffectFaceManager", 2, "parseConfig： version=" + ((JSONObject)localObject).getString("version"));
      }
      if (((JSONObject)localObject).has("black_list"))
      {
        localObject = ((JSONObject)localObject).getJSONArray("black_list");
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          i += 1;
        }
      }
      return super.b(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString) {}
  
  public void b(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.EffectFaceManager
 * JD-Core Version:    0.7.0.1
 */