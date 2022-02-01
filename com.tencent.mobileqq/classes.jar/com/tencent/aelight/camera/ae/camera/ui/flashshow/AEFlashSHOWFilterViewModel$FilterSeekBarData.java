package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

public class AEFlashSHOWFilterViewModel$FilterSeekBarData
{
  public int a;
  public int b;
  public MetaMaterial c;
  
  /* Error */
  public AEFlashSHOWFilterViewModel$FilterSeekBarData(AEFlashSHOWFilterViewModel paramAEFlashSHOWFilterViewModel, MetaMaterial paramMetaMaterial)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 17	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:d	Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel;
    //   5: aload_0
    //   6: invokespecial 20	java/lang/Object:<init>	()V
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 22	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:a	I
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 24	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:b	I
    //   19: aload_0
    //   20: aload_2
    //   21: putfield 26	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:c	Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;
    //   24: aload_2
    //   25: ldc 28
    //   27: invokestatic 34	com/tencent/mobileqq/wink/editor/MetaMaterialKt:f	(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 4
    //   32: aload_0
    //   33: aload 4
    //   35: invokestatic 40	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   38: putfield 24	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:b	I
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 24	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:b	I
    //   46: putfield 22	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:a	I
    //   49: aload_1
    //   50: aload_2
    //   51: invokestatic 45	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel:a	(Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I
    //   54: istore_3
    //   55: iload_3
    //   56: bipush 156
    //   58: if_icmple +37 -> 95
    //   61: aload_0
    //   62: iload_3
    //   63: putfield 22	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:a	I
    //   66: return
    //   67: astore 4
    //   69: goto +27 -> 96
    //   72: ldc 47
    //   74: iconst_1
    //   75: ldc 49
    //   77: invokestatic 55	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_1
    //   81: aload_2
    //   82: invokestatic 45	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel:a	(Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I
    //   85: istore_3
    //   86: iload_3
    //   87: bipush 156
    //   89: if_icmple +6 -> 95
    //   92: goto -31 -> 61
    //   95: return
    //   96: aload_1
    //   97: aload_2
    //   98: invokestatic 45	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel:a	(Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I
    //   101: istore_3
    //   102: iload_3
    //   103: bipush 156
    //   105: if_icmple +8 -> 113
    //   108: aload_0
    //   109: iload_3
    //   110: putfield 22	com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashSHOWFilterViewModel$FilterSeekBarData:a	I
    //   113: goto +6 -> 119
    //   116: aload 4
    //   118: athrow
    //   119: goto -3 -> 116
    //   122: astore 4
    //   124: goto -52 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	FilterSeekBarData
    //   0	127	1	paramAEFlashSHOWFilterViewModel	AEFlashSHOWFilterViewModel
    //   0	127	2	paramMetaMaterial	MetaMaterial
    //   54	56	3	i	int
    //   30	4	4	str	java.lang.String
    //   67	50	4	localObject	Object
    //   122	1	4	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   32	49	67	finally
    //   72	80	67	finally
    //   32	49	122	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashSHOWFilterViewModel.FilterSeekBarData
 * JD-Core Version:    0.7.0.1
 */