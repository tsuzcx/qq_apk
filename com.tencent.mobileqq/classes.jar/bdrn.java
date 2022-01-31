import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class bdrn
{
  private static bdrn jdField_a_of_type_Bdrn = new bdrn(102400);
  protected static final Comparator<byte[]> a;
  private int jdField_a_of_type_Int;
  private List<byte[]> jdField_a_of_type_JavaUtilList = new LinkedList();
  private final int jdField_b_of_type_Int;
  private List<byte[]> jdField_b_of_type_JavaUtilList = new ArrayList(64);
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new bdro();
  }
  
  public bdrn(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public static bdrn a()
  {
    return jdField_a_of_type_Bdrn;
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int)
      {
        byte[] arrayOfByte = (byte[])this.jdField_a_of_type_JavaUtilList.remove(0);
        this.jdField_b_of_type_JavaUtilList.remove(arrayOfByte);
        this.jdField_a_of_type_Int -= arrayOfByte.length;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: arraylength
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 41	bdrn:jdField_b_of_type_Int	I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmple +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 34	bdrn:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 59 2 0
    //   32: pop
    //   33: aload_0
    //   34: getfield 39	bdrn:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   37: aload_1
    //   38: getstatic 27	bdrn:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   41: invokestatic 65	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   44: istore_3
    //   45: iload_3
    //   46: istore_2
    //   47: iload_3
    //   48: ifge +8 -> 56
    //   51: iload_3
    //   52: ineg
    //   53: iconst_1
    //   54: isub
    //   55: istore_2
    //   56: aload_0
    //   57: getfield 39	bdrn:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   60: iload_2
    //   61: aload_1
    //   62: invokeinterface 68 3 0
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 44	bdrn:jdField_a_of_type_Int	I
    //   72: aload_1
    //   73: arraylength
    //   74: iadd
    //   75: putfield 44	bdrn:jdField_a_of_type_Int	I
    //   78: aload_0
    //   79: invokespecial 70	bdrn:a	()V
    //   82: goto -63 -> 19
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	bdrn
    //   0	90	1	paramArrayOfByte	byte[]
    //   8	53	2	i	int
    //   13	39	3	j	int
    // Exception table:
    //   from	to	target	type
    //   6	14	85	finally
    //   22	45	85	finally
    //   56	82	85	finally
  }
  
  /* Error */
  public byte[] a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 39	bdrn:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   9: invokeinterface 75 1 0
    //   14: if_icmpge +67 -> 81
    //   17: aload_0
    //   18: getfield 39	bdrn:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 78 2 0
    //   27: checkcast 52	[B
    //   30: astore_3
    //   31: aload_3
    //   32: arraylength
    //   33: iload_1
    //   34: if_icmplt +40 -> 74
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 44	bdrn:jdField_a_of_type_Int	I
    //   42: aload_3
    //   43: arraylength
    //   44: isub
    //   45: putfield 44	bdrn:jdField_a_of_type_Int	I
    //   48: aload_0
    //   49: getfield 39	bdrn:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface 50 2 0
    //   58: pop
    //   59: aload_0
    //   60: getfield 34	bdrn:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   63: aload_3
    //   64: invokeinterface 55 2 0
    //   69: pop
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: areturn
    //   74: iload_2
    //   75: iconst_1
    //   76: iadd
    //   77: istore_2
    //   78: goto -74 -> 4
    //   81: iload_1
    //   82: newarray byte
    //   84: astore_3
    //   85: goto -15 -> 70
    //   88: astore_3
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	bdrn
    //   0	93	1	paramInt	int
    //   3	75	2	i	int
    //   30	55	3	arrayOfByte	byte[]
    //   88	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	70	88	finally
    //   81	85	88	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdrn
 * JD-Core Version:    0.7.0.1
 */