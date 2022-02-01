import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.Utils;
import com.wx.voice.vad.WXVad;
import com.wx.voice.vad.WXVadData;
import com.wx.voice.vad.WXVadParam;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class bhik
{
  private WXVad jdField_a_of_type_ComWxVoiceVadWXVad;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  
  static
  {
    System.loadLibrary("wx-asr-vad");
  }
  
  private WXVadParam a()
  {
    WXVadParam localWXVadParam = new WXVadParam();
    localWXVadParam.mode = 0;
    localWXVadParam.sample_rate = 16000;
    localWXVadParam.opt_spk_time = 3000;
    localWXVadParam.online_begin_win = 300;
    localWXVadParam.online_begin_confirm_time = 225;
    localWXVadParam.online_sil_timeout = 10;
    localWXVadParam.online_energy_thresh = 10.0F;
    localWXVadParam.online_cross_zero_thresh = 0.01F;
    localWXVadParam.online_max_spk_time = 30000;
    localWXVadParam.online_begin_padding_ms = 150;
    localWXVadParam.online_rtcmode = 3;
    localWXVadParam.online_output_data_size = 3200;
    localWXVadParam.online_end_sil_decrease_slope = -0.01F;
    return localWXVadParam;
  }
  
  private WXVadParam b()
  {
    WXVadParam localWXVadParam = new WXVadParam();
    localWXVadParam.mode = 1;
    localWXVadParam.sample_rate = 16000;
    localWXVadParam.opt_spk_time = 3000;
    localWXVadParam.offline_min_spk_time = 80;
    localWXVadParam.offline_max_spk_time = 50000;
    localWXVadParam.offline_min_nspk_time = 50;
    localWXVadParam.offline_min_process_time = 10000;
    localWXVadParam.offline_remove_sil = true;
    localWXVadParam.offline_padding_btime = 100;
    localWXVadParam.offline_padding_etime = 150;
    localWXVadParam.offline_min_sil_time = 600;
    localWXVadParam.offline_rtcmode = 3;
    return localWXVadParam;
  }
  
  public WXVadData a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bakl.a("VadHelper", "vadOnlineProcess isError ");
      return null;
    }
    short[] arrayOfShort = Utils.toShortArray(paramArrayOfByte);
    return this.jdField_a_of_type_ComWxVoiceVadWXVad.OnlineProcess(arrayOfShort, paramArrayOfByte.length / 2, 0);
  }
  
  /* Error */
  public java.util.List<com.wx.voice.vad.WXVadSeg> a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	bhik:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 137	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifne +10 -> 17
    //   10: aload_0
    //   11: getfield 107	bhik:jdField_a_of_type_Boolean	Z
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 27	bhik:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_1
    //   24: invokevirtual 141	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: new 143	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 144	java/util/ArrayList:<init>	()V
    //   34: astore 6
    //   36: new 146	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: new 150	java/io/FileInputStream
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 153	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore 4
    //   57: aload 4
    //   59: astore_1
    //   60: aload 5
    //   62: invokevirtual 157	java/io/File:length	()J
    //   65: lstore_2
    //   66: aload 4
    //   68: astore_1
    //   69: aload 4
    //   71: iconst_0
    //   72: i2l
    //   73: invokevirtual 161	java/io/FileInputStream:skip	(J)J
    //   76: pop2
    //   77: aload 4
    //   79: astore_1
    //   80: lload_2
    //   81: iconst_0
    //   82: i2l
    //   83: lsub
    //   84: l2i
    //   85: newarray byte
    //   87: astore 5
    //   89: aload 4
    //   91: astore_1
    //   92: aload 4
    //   94: aload 5
    //   96: invokevirtual 165	java/io/FileInputStream:read	([B)I
    //   99: pop
    //   100: aload 4
    //   102: astore_1
    //   103: aload 5
    //   105: invokestatic 122	com/wx/voice/vad/Utils:toShortArray	([B)[S
    //   108: astore 5
    //   110: aload 4
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 124	bhik:jdField_a_of_type_ComWxVoiceVadWXVad	Lcom/wx/voice/vad/WXVad;
    //   117: aload 5
    //   119: aload 5
    //   121: arraylength
    //   122: i2l
    //   123: invokevirtual 169	com/wx/voice/vad/WXVad:OfflineProcess	([SJ)Lcom/wx/voice/vad/WXVadData;
    //   126: astore 5
    //   128: aload 4
    //   130: astore_1
    //   131: aload 5
    //   133: getfield 174	com/wx/voice/vad/WXVadData:RET_STATE	I
    //   136: iconst_1
    //   137: if_icmpeq +19 -> 156
    //   140: aload 4
    //   142: astore_1
    //   143: aload 6
    //   145: aload 5
    //   147: getfield 178	com/wx/voice/vad/WXVadData:offline_odata	Ljava/util/ArrayList;
    //   150: invokeinterface 184 2 0
    //   155: pop
    //   156: aload 4
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 124	bhik:jdField_a_of_type_ComWxVoiceVadWXVad	Lcom/wx/voice/vad/WXVad;
    //   163: invokevirtual 188	com/wx/voice/vad/WXVad:Reset	()I
    //   166: pop
    //   167: aload 4
    //   169: astore_1
    //   170: aload_0
    //   171: getfield 27	bhik:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   174: iconst_0
    //   175: invokevirtual 141	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   178: aload 4
    //   180: invokevirtual 191	java/io/FileInputStream:close	()V
    //   183: aload 6
    //   185: areturn
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   191: aload 6
    //   193: areturn
    //   194: astore 5
    //   196: aconst_null
    //   197: astore 4
    //   199: aload 4
    //   201: astore_1
    //   202: aload 5
    //   204: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   207: aload 4
    //   209: astore_1
    //   210: aload_0
    //   211: getfield 27	bhik:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   214: iconst_0
    //   215: invokevirtual 141	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   218: aload 4
    //   220: invokevirtual 191	java/io/FileInputStream:close	()V
    //   223: aload 6
    //   225: areturn
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   231: aload 6
    //   233: areturn
    //   234: astore 4
    //   236: aconst_null
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 191	java/io/FileInputStream:close	()V
    //   242: aload 4
    //   244: athrow
    //   245: astore_1
    //   246: aload_1
    //   247: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   250: goto -8 -> 242
    //   253: astore 4
    //   255: goto -17 -> 238
    //   258: astore 5
    //   260: goto -61 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	bhik
    //   0	263	1	paramString	java.lang.String
    //   65	16	2	l	long
    //   55	164	4	localFileInputStream	java.io.FileInputStream
    //   234	9	4	localObject1	Object
    //   253	1	4	localObject2	Object
    //   44	102	5	localObject3	Object
    //   194	9	5	localException1	java.lang.Exception
    //   258	1	5	localException2	java.lang.Exception
    //   34	198	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   178	183	186	java/lang/Exception
    //   46	57	194	java/lang/Exception
    //   218	223	226	java/lang/Exception
    //   46	57	234	finally
    //   238	242	245	java/lang/Exception
    //   60	66	253	finally
    //   69	77	253	finally
    //   80	89	253	finally
    //   92	100	253	finally
    //   103	110	253	finally
    //   113	128	253	finally
    //   131	140	253	finally
    //   143	156	253	finally
    //   159	167	253	finally
    //   170	178	253	finally
    //   202	207	253	finally
    //   210	218	253	finally
    //   60	66	258	java/lang/Exception
    //   69	77	258	java/lang/Exception
    //   80	89	258	java/lang/Exception
    //   92	100	258	java/lang/Exception
    //   103	110	258	java/lang/Exception
    //   113	128	258	java/lang/Exception
    //   131	140	258	java/lang/Exception
    //   143	156	258	java/lang/Exception
    //   159	167	258	java/lang/Exception
    //   170	178	258	java/lang/Exception
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComWxVoiceVadWXVad != null) {
      this.jdField_a_of_type_ComWxVoiceVadWXVad.Reset();
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      bakl.a("VadHelper", "vadSession, input empty, skipped");
      return true;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    paramArrayOfByte = Utils.toShortArray(paramArrayOfByte);
    if (paramBoolean)
    {
      paramArrayOfByte = this.jdField_a_of_type_ComWxVoiceVadWXVad.OnlineProcess(paramArrayOfByte, paramArrayOfByte.length, 0);
      bakl.a("VadHelper", "vadSession online RET_STATE:" + paramArrayOfByte.RET_STATE);
      if (paramArrayOfByte.RET_STATE != 2) {
        paramBoolean = bool1;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return paramBoolean;
      paramBoolean = false;
      continue;
      paramArrayOfByte = this.jdField_a_of_type_ComWxVoiceVadWXVad.OfflineProcess(paramArrayOfByte, paramArrayOfByte.length);
      bakl.a("VadHelper", "vadSession offline RET_STATE:" + paramArrayOfByte.RET_STATE);
      paramBoolean = bool2;
      if (paramArrayOfByte.RET_STATE != 1) {
        paramBoolean = paramArrayOfByte.offline_odata.isEmpty();
      }
      a();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComWxVoiceVadWXVad != null) {
      this.jdField_a_of_type_ComWxVoiceVadWXVad.Release();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComWxVoiceVadWXVad = new WXVad();
    this.jdField_a_of_type_Boolean = false;
    if (1 == this.jdField_a_of_type_ComWxVoiceVadWXVad.Init(a()))
    {
      this.jdField_a_of_type_Boolean = true;
      bakl.a("VadHelper", "WXVad Error reading configure");
    }
    WXVadData localWXVadData;
    for (;;)
    {
      localWXVadData = this.jdField_a_of_type_ComWxVoiceVadWXVad.GetOnlineProcessDataSize();
      if (1 != localWXVadData.RET_STATE) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      bakl.a("VadHelper", "WXVad Error reading blocksize");
      return;
      bakl.a("VadHelper", "WXVad Success init");
    }
    bakl.a("VadHelper", "WXVad success get blocksize ：" + localWXVadData.blocksize);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComWxVoiceVadWXVad = new WXVad();
    if (1 == this.jdField_a_of_type_ComWxVoiceVadWXVad.Init(b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VadHelper", 2, "WXVad Error reading configure");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhik
 * JD-Core Version:    0.7.0.1
 */