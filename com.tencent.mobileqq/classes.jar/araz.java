import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class araz
  implements URLDrawable.DownloadListener
{
  int jdField_a_of_type_Int = 1;
  SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private HotPicPageView jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private LinkedList<URLDrawable> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  boolean jdField_a_of_type_Boolean = false;
  volatile int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  
  public araz(HotPicPageView paramHotPicPageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView = paramHotPicPageView;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_b_of_type_Int == 0)
    {
      b(true);
      return;
    }
    b(false);
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	araz:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 46	araz:jdField_b_of_type_Int	I
    //   14: iconst_1
    //   15: isub
    //   16: putfield 46	araz:jdField_b_of_type_Int	I
    //   19: aload_0
    //   20: getfield 46	araz:jdField_b_of_type_Int	I
    //   23: aload_0
    //   24: getfield 27	araz:jdField_a_of_type_Int	I
    //   27: if_icmpge +88 -> 115
    //   30: aload_0
    //   31: getfield 34	araz:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   34: invokevirtual 62	java/util/LinkedList:size	()I
    //   37: ifle +78 -> 115
    //   40: aload_0
    //   41: getfield 34	araz:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   44: invokevirtual 66	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   47: checkcast 68	com/tencent/image/URLDrawable
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 71	com/tencent/image/URLDrawable:getStatus	()I
    //   55: iconst_1
    //   56: if_icmpeq -37 -> 19
    //   59: aload_2
    //   60: invokevirtual 71	com/tencent/image/URLDrawable:getStatus	()I
    //   63: iconst_2
    //   64: if_icmpne +94 -> 158
    //   67: aload_2
    //   68: invokevirtual 74	com/tencent/image/URLDrawable:restartDownload	()V
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 46	araz:jdField_b_of_type_Int	I
    //   76: iconst_1
    //   77: iadd
    //   78: putfield 46	araz:jdField_b_of_type_Int	I
    //   81: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +31 -> 115
    //   87: ldc 82
    //   89: iconst_2
    //   90: new 84	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   97: ldc 87
    //   99: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 46	araz:jdField_b_of_type_Int	I
    //   106: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_0
    //   116: getfield 46	araz:jdField_b_of_type_Int	I
    //   119: ifne +34 -> 153
    //   122: aload_0
    //   123: getfield 34	araz:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   126: invokevirtual 62	java/util/LinkedList:size	()I
    //   129: ifne +24 -> 153
    //   132: aload_0
    //   133: getfield 50	araz:jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView	Lcom/tencent/mobileqq/hotpic/HotPicPageView;
    //   136: ifnull +17 -> 153
    //   139: aload_0
    //   140: getfield 25	araz:jdField_a_of_type_Boolean	Z
    //   143: ifeq +10 -> 153
    //   146: aload_0
    //   147: getfield 50	araz:jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView	Lcom/tencent/mobileqq/hotpic/HotPicPageView;
    //   150: invokevirtual 105	com/tencent/mobileqq/hotpic/HotPicPageView:m	()V
    //   153: aload_1
    //   154: monitorexit
    //   155: aload_0
    //   156: monitorexit
    //   157: return
    //   158: aload_2
    //   159: invokevirtual 108	com/tencent/image/URLDrawable:startDownload	()V
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 46	araz:jdField_b_of_type_Int	I
    //   167: iconst_1
    //   168: iadd
    //   169: putfield 46	araz:jdField_b_of_type_Int	I
    //   172: goto -57 -> 115
    //   175: astore_2
    //   176: aload_1
    //   177: monitorexit
    //   178: aload_2
    //   179: athrow
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	araz
    //   180	4	1	localObject2	Object
    //   50	109	2	localURLDrawable	URLDrawable
    //   175	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	19	175	finally
    //   19	115	175	finally
    //   115	153	175	finally
    //   153	155	175	finally
    //   158	172	175	finally
    //   176	178	175	finally
    //   2	9	180	finally
    //   178	180	180	finally
  }
  
  public void a()
  {
    try
    {
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    paramURLDrawable.startDownload();
    a(paramURLDrawable, paramInt);
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
            return;
          }
          this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
          paramURLDrawable.setDownloadListener(this);
          if (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int) {
            break label154;
          }
          if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramURLDrawable))
          {
            paramURLDrawable.setAutoDownload(false);
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramURLDrawable);
            int i = this.jdField_a_of_type_JavaUtilLinkedList.size();
            if (!this.jdField_b_of_type_Boolean) {
              break label148;
            }
            paramInt = 20;
            if (i > paramInt)
            {
              paramURLDrawable = (URLDrawable)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
              paramURLDrawable.setAutoDownload(true);
              paramURLDrawable.setDownloadListener(null);
            }
          }
        }
        paramInt = 15;
      }
      finally {}
      label148:
      continue;
      label154:
      if (paramURLDrawable.getStatus() == 2) {
        paramURLDrawable.restartDownload();
      }
      this.jdField_b_of_type_Int += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    int i = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (localIterator.hasNext()) {
        ((URLDrawable)localIterator.next()).setDownloadListener(null);
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(0)).setDownloadListener(null);
      i += 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 3;; i = 4)
      {
        this.jdField_a_of_type_Int = i;
        return;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
    c();
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    int i = (int)paramLong;
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(i));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.b(i);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     araz
 * JD-Core Version:    0.7.0.1
 */