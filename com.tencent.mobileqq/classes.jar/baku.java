import com.tencent.mobileqq.qassistant.core.LoadManager.1;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;

public class baku
  implements INetEngine.INetEngineListener
{
  public baku(LoadManager.1 param1) {}
  
  /* Error */
  public void onResp(com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   4: getfield 25	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: new 27	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   14: ldc 30
    //   16: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: getfield 40	com/tencent/mobileqq/transfile/NetResp:mHttpCode	I
    //   23: invokevirtual 43	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 52	bakl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_1
    //   33: getfield 40	com/tencent/mobileqq/transfile/NetResp:mHttpCode	I
    //   36: sipush 200
    //   39: if_icmpne +170 -> 209
    //   42: aload_0
    //   43: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   46: getfield 25	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: new 27	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   56: ldc 54
    //   58: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   65: getfield 57	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   68: invokevirtual 62	java/io/File:getPath	()Ljava/lang/String;
    //   71: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 64
    //   76: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 66
    //   81: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   88: getfield 69	com/tencent/mobileqq/qassistant/core/LoadManager$1:b	Ljava/lang/String;
    //   91: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 71
    //   96: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 52	bakl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   109: getfield 57	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   112: new 27	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   119: ldc 66
    //   121: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   128: getfield 69	com/tencent/mobileqq/qassistant/core/LoadManager$1:b	Ljava/lang/String;
    //   131: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc 71
    //   136: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 76	nwp:a	(Ljava/io/File;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   149: getfield 79	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   152: iconst_0
    //   153: invokevirtual 85	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   156: aload_0
    //   157: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   160: getfield 88	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_Bakv	Lbakv;
    //   163: ifnull +27 -> 190
    //   166: aload_0
    //   167: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   170: getfield 25	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   173: ldc 90
    //   175: invokestatic 52	bakl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   182: getfield 88	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_Bakv	Lbakv;
    //   185: invokeinterface 94 1 0
    //   190: iconst_1
    //   191: iconst_0
    //   192: invokestatic 97	bakl:a	(ZI)V
    //   195: aload_0
    //   196: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   199: getfield 79	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   202: iconst_1
    //   203: iconst_0
    //   204: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   207: pop
    //   208: return
    //   209: iconst_0
    //   210: aload_1
    //   211: getfield 40	com/tencent/mobileqq/transfile/NetResp:mHttpCode	I
    //   214: invokestatic 97	bakl:a	(ZI)V
    //   217: goto -22 -> 195
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   225: getfield 25	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   228: new 27	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   235: ldc 103
    //   237: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_1
    //   241: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 52	bakl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: iconst_0
    //   251: ldc 107
    //   253: invokestatic 97	bakl:a	(ZI)V
    //   256: aload_0
    //   257: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   260: getfield 79	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   263: iconst_1
    //   264: iconst_0
    //   265: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   268: pop
    //   269: return
    //   270: astore_1
    //   271: aload_0
    //   272: getfield 12	baku:a	Lcom/tencent/mobileqq/qassistant/core/LoadManager$1;
    //   275: getfield 79	com/tencent/mobileqq/qassistant/core/LoadManager$1:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   278: iconst_1
    //   279: iconst_0
    //   280: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   283: pop
    //   284: aload_1
    //   285: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	baku
    //   0	286	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    // Exception table:
    //   from	to	target	type
    //   32	190	220	java/lang/Exception
    //   190	195	220	java/lang/Exception
    //   209	217	220	java/lang/Exception
    //   32	190	270	finally
    //   190	195	270	finally
    //   209	217	270	finally
    //   221	256	270	finally
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baku
 * JD-Core Version:    0.7.0.1
 */