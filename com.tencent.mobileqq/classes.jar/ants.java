import android.os.Environment;
import android.view.View;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import java.io.File;
import java.io.IOException;

public class ants
{
  private int jdField_a_of_type_Int;
  File jdField_a_of_type_JavaIoFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ants(DragSortListView paramDragSortListView)
  {
    if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    try
    {
      this.jdField_a_of_type_JavaIoFile.createNewFile();
      return;
    }
    catch (IOException paramDragSortListView) {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append("<DSLVStates>\n");
    this.b = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangStringBuilder.append("<DSLVState>\n");
      int j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildCount();
      int k = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getFirstVisiblePosition();
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <Positions>");
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(k + i).append(",");
        i += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("</Positions>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <Tops>");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i).getTop()).append(",");
        i += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("</Tops>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <Bottoms>");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i).getBottom()).append(",");
        i += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("</Bottoms>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <FirstExpPos>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c).append("</FirstExpPos>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <FirstExpBlankHeight>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c) - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c)).append("</FirstExpBlankHeight>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <SecondExpPos>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d).append("</SecondExpPos>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <SecondExpBlankHeight>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d) - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d)).append("</SecondExpBlankHeight>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <SrcPos>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.e).append("</SrcPos>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <SrcHeight>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.i + this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getDividerHeight()).append("</SrcHeight>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <ViewHeight>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeight()).append("</ViewHeight>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <LastY>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.l).append("</LastY>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <FloatY>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Int).append("</FloatY>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <ShuffleEdges>");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(k + i, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i).getTop())).append(",");
        i += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("</ShuffleEdges>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("</DSLVState>\n");
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Int <= 1000);
    c();
    this.jdField_a_of_type_Int = 0;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 58	ants:jdField_a_of_type_Boolean	Z
    //   6: ifne +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 56	ants:b	I
    //   14: ifne +119 -> 133
    //   17: new 176	java/io/FileWriter
    //   20: dup
    //   21: aload_0
    //   22: getfield 40	ants:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   25: iload_1
    //   26: invokespecial 179	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   29: astore_2
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 25	ants:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   35: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 187	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 25	ants:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   45: iconst_0
    //   46: aload_0
    //   47: getfield 25	ants:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   50: invokevirtual 190	java/lang/StringBuilder:length	()I
    //   53: invokevirtual 194	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: invokevirtual 197	java/io/FileWriter:flush	()V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 56	ants:b	I
    //   66: iconst_1
    //   67: iadd
    //   68: putfield 56	ants:b	I
    //   71: aload_2
    //   72: ifnull -63 -> 9
    //   75: aload_2
    //   76: invokevirtual 200	java/io/FileWriter:close	()V
    //   79: return
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   85: return
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull -81 -> 9
    //   93: aload_2
    //   94: invokevirtual 200	java/io/FileWriter:close	()V
    //   97: return
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   103: return
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 200	java/io/FileWriter:close	()V
    //   115: aload_3
    //   116: athrow
    //   117: astore_2
    //   118: aload_2
    //   119: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_3
    //   126: goto -19 -> 107
    //   129: astore_3
    //   130: goto -41 -> 89
    //   133: iconst_1
    //   134: istore_1
    //   135: goto -118 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	ants
    //   1	134	1	bool	boolean
    //   29	47	2	localFileWriter	java.io.FileWriter
    //   80	2	2	localIOException1	IOException
    //   86	1	2	localIOException2	IOException
    //   88	6	2	localObject1	Object
    //   98	2	2	localIOException3	IOException
    //   106	6	2	localObject2	Object
    //   117	2	2	localIOException4	IOException
    //   104	12	3	localObject3	Object
    //   125	1	3	localObject4	Object
    //   129	1	3	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   75	79	80	java/io/IOException
    //   17	30	86	java/io/IOException
    //   93	97	98	java/io/IOException
    //   17	30	104	finally
    //   111	115	117	java/io/IOException
    //   30	71	125	finally
    //   30	71	129	java/io/IOException
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("</DSLVStates>\n");
      c();
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ants
 * JD-Core Version:    0.7.0.1
 */