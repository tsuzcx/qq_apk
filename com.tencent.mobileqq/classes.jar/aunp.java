import android.os.Bundle;
import com.tencent.mobileqq.flutter.channel.model.CardCoverData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class aunp
  extends QIPCModule
  implements EIPCResultCallback
{
  WeakReference<auns> jdField_a_of_type_JavaLangRefWeakReference = null;
  private volatile boolean jdField_a_of_type_Boolean;
  
  private aunp()
  {
    super("ZanRankingIpcClient");
  }
  
  public static aunp a()
  {
    return aunr.a();
  }
  
  public Map<String, String> a(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putStringArrayList("uins", paramArrayList);
    paramArrayList = QIPCClientHelper.getInstance().getClient().callServer("ZanRankingIpcServer", "action_get_frd_nicks", (Bundle)localObject1);
    if (paramArrayList.isSuccess())
    {
      Object localObject2 = paramArrayList.data;
      localObject1 = ((Bundle)localObject2).getStringArrayList("uins");
      localObject2 = ((Bundle)localObject2).getStringArrayList("nicks");
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localHashMap.put(((ArrayList)localObject1).get(i), ((ArrayList)localObject2).get(i));
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ZanRankingIpcClient", 2, String.format("getFrdNicks suc=%b nicks.size=%d", new Object[] { Boolean.valueOf(paramArrayList.isSuccess()), Integer.valueOf(localHashMap.size()) }));
    }
    return localHashMap;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	aunp:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 131	aunp:a	()Launp;
    //   17: astore_2
    //   18: invokestatic 47	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   21: aload_2
    //   22: invokevirtual 135	com/tencent/mobileqq/qipc/QIPCClientHelper:register	(Lcom/tencent/mobileqq/qipc/QIPCModule;)V
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 130	aunp:jdField_a_of_type_Boolean	Z
    //   30: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq -22 -> 11
    //   36: ldc 14
    //   38: iconst_2
    //   39: ldc 137
    //   41: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: goto -33 -> 11
    //   47: astore_2
    //   48: ldc 14
    //   50: iconst_1
    //   51: ldc 142
    //   53: aload_2
    //   54: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   57: goto -46 -> 11
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	aunp
    //   6	2	1	bool	boolean
    //   17	5	2	localaunp	aunp
    //   47	7	2	localException	Exception
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	44	47	java/lang/Exception
    //   2	7	60	finally
    //   14	18	60	finally
    //   18	44	60	finally
    //   48	57	60	finally
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "action_get_card_cover");
    localBundle.putString("uin", paramString);
    localBundle.putBoolean("fromCache", paramBoolean);
    localBundle.putInt("seq", paramInt);
    QIPCClientHelper.getInstance().getClient().callServer("ZanRankingIpcServer", "action_get_card_cover", localBundle, this);
  }
  
  public void a(auns paramauns)
  {
    if (paramauns != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramauns);
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	aunp:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +43 -> 51
    //   11: invokestatic 47	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   14: invokevirtual 51	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   17: ifnull +34 -> 51
    //   20: invokestatic 47	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   23: invokevirtual 51	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   26: invokestatic 131	aunp:a	()Launp;
    //   29: invokevirtual 183	eipc/EIPCClient:unRegisterModule	(Leipc/EIPCModule;)V
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 130	aunp:jdField_a_of_type_Boolean	Z
    //   37: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +11 -> 51
    //   43: ldc 14
    //   45: iconst_2
    //   46: ldc 185
    //   48: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_2
    //   55: ldc 14
    //   57: iconst_1
    //   58: ldc 187
    //   60: aload_2
    //   61: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   64: goto -13 -> 51
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	aunp
    //   6	2	1	bool	boolean
    //   54	7	2	localException	Exception
    //   67	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	51	54	java/lang/Exception
    //   2	7	67	finally
    //   11	51	67	finally
    //   55	64	67	finally
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZanRankingIpcClient", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    return null;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((!paramEIPCResult.isSuccess()) || (paramEIPCResult.data == null)) {
          break;
        }
        paramEIPCResult = paramEIPCResult.data;
        String str = paramEIPCResult.getString("action", "");
        QLog.d("ZanRankingIpcClient", 1, "onCallback result action= " + str);
        if (!str.equals("action_get_card_cover")) {
          break;
        }
        int i = paramEIPCResult.getInt("seq");
        str = paramEIPCResult.getString("uin");
        boolean bool = paramEIPCResult.getBoolean("fromCache");
        CardCoverData localCardCoverData = new CardCoverData(paramEIPCResult.getInt("type"), paramEIPCResult.getString("text"));
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramEIPCResult = (auns)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramEIPCResult == null) {
            break;
          }
          paramEIPCResult.a(i, str, bool, localCardCoverData);
          return;
        }
      }
      catch (Exception paramEIPCResult)
      {
        return;
      }
      paramEIPCResult = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunp
 * JD-Core Version:    0.7.0.1
 */