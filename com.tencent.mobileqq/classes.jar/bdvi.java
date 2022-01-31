import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro<*>;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;

public abstract class bdvi
  extends ajtb
{
  private aysa jdField_a_of_type_Aysa;
  private bdvh jdField_a_of_type_Bdvh;
  public bdvm a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<bdvl> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  protected bdvi(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Bdvm = new bdvj(this);
    this.jdField_a_of_type_Bdvh = ((bdvh)paramQQAppInterface.a(104));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Bdvm);
    this.jdField_a_of_type_Aysa = paramQQAppInterface.getNetEngine(0);
  }
  
  private int a(int paramInt1, MessageMicro<?> paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    int i = 1;
    String str = this.jdField_a_of_type_Bdvh.a();
    if (this.jdField_a_of_type_Bdvh.a() == null) {
      if (paramBoolean) {
        i = 2;
      }
    }
    do
    {
      do
      {
        do
        {
          return i;
        } while (this.jdField_a_of_type_Bdvh.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
        return 3;
        if (this.jdField_a_of_type_Bdvh.b() != null) {
          break;
        }
        if (paramBoolean) {
          return 4;
        }
      } while (this.jdField_a_of_type_Bdvh.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
      return 5;
      if ((str != null) && (str.length() != 0)) {
        break;
      }
      if (paramBoolean) {
        return 6;
      }
    } while (this.jdField_a_of_type_Bdvh.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
    return 7;
    return 0;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          bdvl localbdvl = (bdvl)localIterator.next();
          a(localbdvl.a(), localbdvl.a(), true, localbdvl.b(), localbdvl.a());
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void a(int paramInt1, MessageMicro<?> paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    int i = a(paramInt1, paramMessageMicro, paramBoolean, paramInt2, paramObject);
    if (i == 1)
    {
      QLog.d("BigDataHandler", 1, "We will wait getIPList call back to do bigData Req" + paramInt1);
      if (!paramBoolean) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.add(new bdvl(paramInt1, paramMessageMicro, paramInt2, paramObject));
          return;
        }
      }
    }
    else
    {
      if (i != 0)
      {
        QLog.d("BigDataHandler", 1, "USER command get key error status: " + i);
        a(paramInt1, false, null, paramInt2, paramObject);
        return;
      }
      long l;
      Object localObject2;
      try
      {
        l = Long.parseLong(this.app.getCurrentAccountUin());
        localObject2 = new Cryptor().encrypt(paramMessageMicro.toByteArray(), this.jdField_a_of_type_Bdvh.a());
        paramMessageMicro = new String();
        i = 0;
        while (i < "8.3.0".length())
        {
          ??? = paramMessageMicro;
          if ("8.3.0".charAt(i) != '.') {
            ??? = paramMessageMicro.concat(Character.toString("8.3.0".charAt(i)));
          }
          i += 1;
          paramMessageMicro = (MessageMicro<?>)???;
        }
        ??? = new im_msg_head.LoginSig();
      }
      catch (Exception paramMessageMicro)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, paramInt1 + " uin case long fail");
        }
        a(paramInt1, false, null, paramInt2, paramObject);
        return;
      }
      ((im_msg_head.LoginSig)???).uint32_type.set(22);
      ((im_msg_head.LoginSig)???).bytes_sig.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_Bdvh.b()));
      Object localObject3 = new im_msg_head.HttpConnHead();
      ((im_msg_head.HttpConnHead)localObject3).uint64_uin.set(l);
      ((im_msg_head.HttpConnHead)localObject3).uint32_command.set(1791);
      ((im_msg_head.HttpConnHead)localObject3).uint32_sub_command.set(paramInt2);
      ((im_msg_head.HttpConnHead)localObject3).uint32_seq.set(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet());
      ((im_msg_head.HttpConnHead)localObject3).uint32_version.set(Integer.parseInt(paramMessageMicro));
      ((im_msg_head.HttpConnHead)localObject3).uint32_flag.set(1);
      ((im_msg_head.HttpConnHead)localObject3).uint32_compress_type.set(0);
      ((im_msg_head.HttpConnHead)localObject3).uint32_error_code.set(0);
      paramMessageMicro = new im_msg_head.Head();
      paramMessageMicro.uint32_head_type.set(4);
      paramMessageMicro.msg_login_sig.set((MessageMicro)???);
      paramMessageMicro.msg_httpconn_head.set((MessageMicro)localObject3);
      ??? = paramMessageMicro.toByteArray();
      paramMessageMicro = new ByteArrayOutputStream();
      try
      {
        localObject3 = new DataOutputStream(paramMessageMicro);
        ((DataOutputStream)localObject3).write(40);
        ((DataOutputStream)localObject3).writeInt(???.length);
        ((DataOutputStream)localObject3).writeInt(localObject2.length);
        ((DataOutputStream)localObject3).write((byte[])???);
        ((DataOutputStream)localObject3).write((byte[])localObject2);
        ((DataOutputStream)localObject3).write(41);
        ((DataOutputStream)localObject3).flush();
        ??? = this.jdField_a_of_type_Bdvh.a();
        ??? = (String)??? + "cgi-bin/httpconn";
        paramMessageMicro = paramMessageMicro.toByteArray();
        localObject2 = new ayrx();
        ((ayrx)localObject2).a(paramObject);
        ((ayrx)localObject2).jdField_a_of_type_ArrayOfByte = paramMessageMicro;
        ((ayrx)localObject2).jdField_a_of_type_Aysc = new bdvk(paramInt1, this, this.jdField_a_of_type_Bdvh.a(), paramInt2, paramObject);
        ((ayrx)localObject2).jdField_a_of_type_JavaLangString = ((String)???);
        ((ayrx)localObject2).jdField_a_of_type_Int = 1;
        ((ayrx)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
        if (this.jdField_a_of_type_Aysa != null)
        {
          this.jdField_a_of_type_Aysa.a((aysy)localObject2);
          return;
        }
      }
      catch (Exception paramMessageMicro)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, paramMessageMicro.getMessage());
        }
        a(paramInt1, false, null, paramInt2, paramObject);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          bdvl localbdvl = (bdvl)localIterator.next();
          a(localbdvl.a(), false, null, localbdvl.b(), localbdvl.a());
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(int paramInt1, MessageMicro<?> paramMessageMicro, int paramInt2, Object paramObject)
  {
    a(paramInt1, paramMessageMicro, false, paramInt2, paramObject);
  }
  
  protected abstract void a(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, Object paramObject);
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Bdvm);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bdvi
 * JD-Core Version:    0.7.0.1
 */