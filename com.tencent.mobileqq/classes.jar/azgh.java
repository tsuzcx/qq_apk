import android.media.MediaPlayer;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.tts.SilkStreamPlayer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class azgh
  implements bflu
{
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private azgg jdField_a_of_type_Azgg;
  private SilkStreamPlayer jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
  private String jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131719583);
  private TicketManager jdField_a_of_type_MqqManagerTicketManager;
  private String b = BaseApplicationImpl.getContext().getString(2131719580);
  private String c = BaseApplicationImpl.getContext().getString(2131719581);
  private String d = BaseApplicationImpl.getContext().getString(2131719596);
  
  /* Error */
  private void a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +28 -> 32
    //   7: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 69
    //   15: iconst_2
    //   16: ldc 71
    //   18: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: aload_1
    //   23: iload_3
    //   24: invokespecial 77	azgh:b	(Ljava/lang/String;I)V
    //   27: aload_0
    //   28: invokespecial 79	azgh:d	()V
    //   31: return
    //   32: aconst_null
    //   33: astore 6
    //   35: aconst_null
    //   36: astore 5
    //   38: aload 6
    //   40: astore 4
    //   42: aload_0
    //   43: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   46: ifnonnull +18 -> 64
    //   49: aload 6
    //   51: astore 4
    //   53: aload_0
    //   54: new 81	android/media/MediaPlayer
    //   57: dup
    //   58: invokespecial 82	android/media/MediaPlayer:<init>	()V
    //   61: putfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   64: aload 6
    //   66: astore 4
    //   68: aload_0
    //   69: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   72: invokevirtual 85	android/media/MediaPlayer:isPlaying	()Z
    //   75: ifeq +14 -> 89
    //   78: aload 6
    //   80: astore 4
    //   82: aload_0
    //   83: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   86: invokevirtual 88	android/media/MediaPlayer:stop	()V
    //   89: aload 6
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   97: invokevirtual 91	android/media/MediaPlayer:reset	()V
    //   100: iload_3
    //   101: ifeq +15 -> 116
    //   104: aload 6
    //   106: astore 4
    //   108: aload_0
    //   109: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   112: iload_3
    //   113: invokevirtual 95	android/media/MediaPlayer:setAudioSessionId	(I)V
    //   116: aload 6
    //   118: astore 4
    //   120: new 97	java/io/FileInputStream
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   128: astore_2
    //   129: aload_0
    //   130: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   133: aload_2
    //   134: invokevirtual 104	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   137: invokevirtual 108	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   140: aload_0
    //   141: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   144: iconst_3
    //   145: invokevirtual 111	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   148: invokestatic 25	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   151: iconst_1
    //   152: invokestatic 116	bftt:a	(Landroid/content/Context;Z)Z
    //   155: pop
    //   156: aload_0
    //   157: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   160: invokevirtual 119	android/media/MediaPlayer:prepare	()V
    //   163: aload_0
    //   164: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   167: new 121	azgi
    //   170: dup
    //   171: aload_0
    //   172: aload_1
    //   173: invokespecial 124	azgi:<init>	(Lazgh;Ljava/lang/String;)V
    //   176: invokevirtual 128	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   179: aload_0
    //   180: getfield 47	azgh:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   183: invokevirtual 131	android/media/MediaPlayer:start	()V
    //   186: aload_0
    //   187: getfield 50	azgh:jdField_a_of_type_Azgg	Lazgg;
    //   190: ifnull +13 -> 203
    //   193: aload_0
    //   194: getfield 50	azgh:jdField_a_of_type_Azgg	Lazgg;
    //   197: aload_1
    //   198: invokeinterface 135 2 0
    //   203: aload_2
    //   204: ifnull -173 -> 31
    //   207: aload_2
    //   208: invokevirtual 138	java/io/FileInputStream:close	()V
    //   211: return
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   217: return
    //   218: astore_2
    //   219: aload 5
    //   221: astore_1
    //   222: aload_1
    //   223: astore 4
    //   225: aload_2
    //   226: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   229: aload_1
    //   230: astore 4
    //   232: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +34 -> 269
    //   238: aload_1
    //   239: astore 4
    //   241: ldc 69
    //   243: iconst_2
    //   244: new 144	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   251: ldc 147
    //   253: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_2
    //   257: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   260: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_1
    //   270: ifnull -239 -> 31
    //   273: aload_1
    //   274: invokevirtual 138	java/io/FileInputStream:close	()V
    //   277: return
    //   278: astore_1
    //   279: aload_1
    //   280: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   283: return
    //   284: astore_1
    //   285: aload 4
    //   287: ifnull +8 -> 295
    //   290: aload 4
    //   292: invokevirtual 138	java/io/FileInputStream:close	()V
    //   295: aload_1
    //   296: athrow
    //   297: astore_2
    //   298: aload_2
    //   299: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   302: goto -7 -> 295
    //   305: astore_1
    //   306: aload_2
    //   307: astore 4
    //   309: goto -24 -> 285
    //   312: astore 4
    //   314: aload_2
    //   315: astore_1
    //   316: aload 4
    //   318: astore_2
    //   319: goto -97 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	azgh
    //   0	322	1	paramString1	String
    //   0	322	2	paramString2	String
    //   0	322	3	paramInt	int
    //   40	268	4	localObject1	Object
    //   312	5	4	localException	Exception
    //   36	184	5	localObject2	Object
    //   33	84	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   207	211	212	java/io/IOException
    //   42	49	218	java/lang/Exception
    //   53	64	218	java/lang/Exception
    //   68	78	218	java/lang/Exception
    //   82	89	218	java/lang/Exception
    //   93	100	218	java/lang/Exception
    //   108	116	218	java/lang/Exception
    //   120	129	218	java/lang/Exception
    //   273	277	278	java/io/IOException
    //   42	49	284	finally
    //   53	64	284	finally
    //   68	78	284	finally
    //   82	89	284	finally
    //   93	100	284	finally
    //   108	116	284	finally
    //   120	129	284	finally
    //   225	229	284	finally
    //   232	238	284	finally
    //   241	269	284	finally
    //   290	295	297	java/io/IOException
    //   129	203	305	finally
    //   129	203	312	java/lang/Exception
  }
  
  private boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      return azfc.a(localArrayList);
    }
    return false;
  }
  
  private void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TTSPlayerManager", 2, "dealOnlinePlay speech is null");
      }
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = new SilkStreamPlayer(BaseApplicationImpl.getContext(), paramString, "", "");
    }
    if ((this.jdField_a_of_type_MqqManagerTicketManager == null) && ((localObject instanceof AppInterface))) {
      this.jdField_a_of_type_MqqManagerTicketManager = ((TicketManager)((AppRuntime)localObject).getManager(2));
    }
    String str = ((AppRuntime)localObject).getAccount();
    localObject = "";
    if (this.jdField_a_of_type_MqqManagerTicketManager != null) {
      localObject = this.jdField_a_of_type_MqqManagerTicketManager.getSkey(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b(str);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.c((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.d(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(this, 1, paramInt);
  }
  
  private void d()
  {
    azfc.a(azfc.a, "TTSPlayerManager", null);
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a())) {
        this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TTSPlayerManager", 2, "stop exception  = " + localException.getMessage());
    }
  }
  
  public void a(azgg paramazgg)
  {
    this.jdField_a_of_type_Azgg = paramazgg;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Azgg != null) {
      this.jdField_a_of_type_Azgg.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i = 1;
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("TTSPlayerManager", 2, "play speech is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        a();
        try
        {
          if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
            break label94;
          }
          if (a("network_tip.mp3"))
          {
            a(paramString, azfc.a("network_tip.mp3"), paramInt);
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("TTSPlayerManager", 2, "play exception = " + paramString.getMessage());
    return;
    label94:
    if (paramString.equals(this.d))
    {
      if (a("wake_default_tip.mp3")) {
        a(paramString, azfc.a("wake_default_tip.mp3"), paramInt);
      }
    }
    else if (paramString.equals(this.jdField_a_of_type_JavaLangString))
    {
      if (a("quit_voice_panel_tip.mp3")) {
        a(paramString, azfc.a("quit_voice_panel_tip.mp3"), paramInt);
      }
    }
    else if (paramString.equals(this.c))
    {
      if (a("voice_not_understant_tip.mp3")) {
        a(paramString, azfc.a("voice_not_understant_tip.mp3"), paramInt);
      }
    }
    else
    {
      if (!paramString.equals(this.b)) {
        break label245;
      }
      if (a("voice_not_support_tip.mp3"))
      {
        a(paramString, azfc.a("voice_not_support_tip.mp3"), paramInt);
        return;
      }
    }
    for (;;)
    {
      if (i != 0) {
        d();
      }
      b(paramString, paramInt);
      return;
      label245:
      i = 0;
    }
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Azgg != null) {
      this.jdField_a_of_type_Azgg.b(paramString);
    }
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a()) {
          this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = null;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TTSPlayerManager", 2, "onDestroy exception  = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgh
 * JD-Core Version:    0.7.0.1
 */