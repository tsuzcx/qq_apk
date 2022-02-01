package com.tencent.av.business.handler;

import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.Tlv;
import com.tencent.av.opengl.TlvUtils;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class AVC2CDataHandler
  extends BusinessHandler
{
  AVC2CDataHandler.C2CDataHandlerArray jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandlerArray = null;
  AVC2CDataHandler.FrameDataHandlerArray jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandlerArray = null;
  private AVC2CDataHandler.C2CDataHandler[] jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandler = null;
  private AVC2CDataHandler.FrameDataHandler[] jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandler = null;
  
  public AVC2CDataHandler(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandlerArray != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandlerArray.a.length)
      {
        if (this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandlerArray.a[i] == paramInt) {
          j = i;
        }
        i += 1;
      }
      i = j;
      if (paramBoolean)
      {
        i = j;
        if (j == -1)
        {
          String str = HardCodeUtil.a(2131700965) + paramInt + "]，需要在FrameDataHandlerArray中添加";
          QLog.d("AVDataSender", 1, str);
          throw new IllegalArgumentException(str);
        }
      }
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public static AVC2CDataHandler a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (AVC2CDataHandler)paramVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.d);
  }
  
  private AVC2CDataHandler.C2CDataHandler[] a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandler == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandler == null)
      {
        this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandlerArray = new AVC2CDataHandler.C2CDataHandlerArray();
        this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandler = new AVC2CDataHandler.C2CDataHandler[this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandlerArray.a.length];
      }
      return this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandler;
    }
    finally {}
  }
  
  private AVC2CDataHandler.FrameDataHandler[] a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandler == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandler == null)
      {
        this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandlerArray = new AVC2CDataHandler.FrameDataHandlerArray();
        this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandler = new AVC2CDataHandler.FrameDataHandler[this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandlerArray.a.length];
      }
      return this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandler;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandlerArray != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandlerArray.a.length)
      {
        if (this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandlerArray.a[i] == paramInt) {
          j = i;
        }
        i += 1;
      }
      i = j;
      if (paramBoolean)
      {
        i = j;
        if (j == -1)
        {
          String str = HardCodeUtil.a(2131700967) + paramInt + "]，需要在C2CDataHandlerArray中添加";
          QLog.d("AVDataSender", 1, str);
          throw new IllegalArgumentException(str);
        }
      }
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public int a(ArrayList<Tlv> paramArrayList)
  {
    int i = 0;
    AVC2CDataHandler.FrameDataHandler[] arrayOfFrameDataHandler = this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandler;
    if (arrayOfFrameDataHandler == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOfFrameDataHandler.length; j = k)
    {
      Object localObject = arrayOfFrameDataHandler[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((AVC2CDataHandler.FrameDataHandler)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((Tlv)localObject).a();
        }
      }
      i += 1;
    }
    return j;
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
      localByteBuffer.putInt(paramInt2);
      if (i > 0) {
        localByteBuffer.put(paramArrayOfByte);
      }
      VideoController.a().a(paramInt1, localByteBuffer.array());
      return;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    AVC2CDataHandler.FrameDataHandler[] arrayOfFrameDataHandler;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOfFrameDataHandler = this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandler;
      if (arrayOfFrameDataHandler != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = TlvUtils.a(paramArrayOfByte);
    int i = 0;
    label28:
    int j;
    if (i < paramArrayOfByte.size())
    {
      j = paramArrayOfByte.keyAt(i);
      int k = a(j, false);
      if (k < 0) {
        break label92;
      }
      AVC2CDataHandler.FrameDataHandler localFrameDataHandler = arrayOfFrameDataHandler[k];
      if (localFrameDataHandler != null) {
        localFrameDataHandler.a(paramString, (Tlv)paramArrayOfByte.valueAt(i));
      }
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      label92:
      if (AudioHelper.d()) {
        QLog.d("AVDataSender", 1, "notifyFrameDataCome, msgType[" + j + "], i[" + i + "]");
      }
    }
  }
  
  public boolean a(int paramInt, AVC2CDataHandler.C2CDataHandler paramC2CDataHandler)
  {
    AVC2CDataHandler.C2CDataHandler[] arrayOfC2CDataHandler = a();
    paramInt = b(paramInt, true);
    if (arrayOfC2CDataHandler[paramInt] == null)
    {
      arrayOfC2CDataHandler[paramInt] = paramC2CDataHandler;
      return true;
    }
    SmallScreenUtils.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, AVC2CDataHandler.FrameDataHandler paramFrameDataHandler)
  {
    Object localObject = VideoController.a().a(true);
    if (localObject == null)
    {
      SmallScreenUtils.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((EffectController)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramFrameDataHandler;
      return true;
    }
    SmallScreenUtils.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandler;
    if (localObject == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = b(paramInt, false);
      } while (i < 0);
      localObject = localObject[i];
    } while (localObject == null);
    return ((AVC2CDataHandler.C2CDataHandler)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), TlvUtils.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, AVC2CDataHandler.FrameDataHandler paramFrameDataHandler)
  {
    paramInt = a(paramInt, true);
    AVC2CDataHandler.FrameDataHandler[] arrayOfFrameDataHandler = this.jdField_a_of_type_ArrayOfComTencentAvBusinessHandlerAVC2CDataHandler$FrameDataHandler;
    if ((arrayOfFrameDataHandler != null) && (arrayOfFrameDataHandler[paramInt] != null) && (paramFrameDataHandler.equals(arrayOfFrameDataHandler[paramInt])))
    {
      arrayOfFrameDataHandler[paramInt] = null;
      return true;
    }
    SmallScreenUtils.a("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = SeqUtil.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.handler.AVC2CDataHandler
 * JD-Core Version:    0.7.0.1
 */