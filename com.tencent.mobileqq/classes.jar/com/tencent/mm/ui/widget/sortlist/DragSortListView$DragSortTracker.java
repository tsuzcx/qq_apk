package com.tencent.mm.ui.widget.sortlist;

import android.os.Environment;
import android.view.View;
import com.tencent.mm.ui.f;
import java.io.File;
import java.io.IOException;

class DragSortListView$DragSortTracker
{
  StringBuilder a = new StringBuilder();
  File b = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
  private int d = 0;
  private int e = 0;
  private boolean f = false;
  
  DragSortListView$DragSortTracker(DragSortListView paramDragSortListView)
  {
    if (!this.b.exists()) {
      try
      {
        if (!this.b.createNewFile()) {
          f.e("mobeta", "creat file fail!! file already exist", new Object[0]);
        }
        f.b("mobeta", "file created", new Object[0]);
        return;
      }
      catch (IOException paramDragSortListView)
      {
        f.d("mobeta", "Could not create dslv_state.txt", new Object[0]);
        f.b("mobeta", paramDragSortListView.getMessage(), new Object[0]);
      }
    }
  }
  
  public void appendState()
  {
    if (!this.f) {
      return;
    }
    this.a.append("<DSLVState>\n");
    int j = this.c.getChildCount();
    int k = this.c.getFirstVisiblePosition();
    this.a.append("    <Positions>");
    int i = 0;
    while (i < j)
    {
      localStringBuilder = this.a;
      localStringBuilder.append(k + i);
      localStringBuilder.append(",");
      i += 1;
    }
    this.a.append("</Positions>\n");
    this.a.append("    <Tops>");
    i = 0;
    while (i < j)
    {
      localStringBuilder = this.a;
      localStringBuilder.append(this.c.getChildAt(i).getTop());
      localStringBuilder.append(",");
      i += 1;
    }
    this.a.append("</Tops>\n");
    this.a.append("    <Bottoms>");
    i = 0;
    while (i < j)
    {
      localStringBuilder = this.a;
      localStringBuilder.append(this.c.getChildAt(i).getBottom());
      localStringBuilder.append(",");
      i += 1;
    }
    this.a.append("</Bottoms>\n");
    StringBuilder localStringBuilder = this.a;
    localStringBuilder.append("    <FirstExpPos>");
    localStringBuilder.append(DragSortListView.l(this.c));
    localStringBuilder.append("</FirstExpPos>\n");
    localStringBuilder = this.a;
    localStringBuilder.append("    <FirstExpBlankHeight>");
    DragSortListView localDragSortListView = this.c;
    i = DragSortListView.c(localDragSortListView, DragSortListView.l(localDragSortListView));
    localDragSortListView = this.c;
    localStringBuilder.append(i - DragSortListView.d(localDragSortListView, DragSortListView.l(localDragSortListView)));
    localStringBuilder.append("</FirstExpBlankHeight>\n");
    localStringBuilder = this.a;
    localStringBuilder.append("    <SecondExpPos>");
    localStringBuilder.append(DragSortListView.m(this.c));
    localStringBuilder.append("</SecondExpPos>\n");
    localStringBuilder = this.a;
    localStringBuilder.append("    <SecondExpBlankHeight>");
    localDragSortListView = this.c;
    i = DragSortListView.c(localDragSortListView, DragSortListView.m(localDragSortListView));
    localDragSortListView = this.c;
    localStringBuilder.append(i - DragSortListView.d(localDragSortListView, DragSortListView.m(localDragSortListView)));
    localStringBuilder.append("</SecondExpBlankHeight>\n");
    localStringBuilder = this.a;
    localStringBuilder.append("    <SrcPos>");
    localStringBuilder.append(DragSortListView.h(this.c));
    localStringBuilder.append("</SrcPos>\n");
    localStringBuilder = this.a;
    localStringBuilder.append("    <SrcHeight>");
    localStringBuilder.append(DragSortListView.j(this.c) + this.c.getDividerHeight());
    localStringBuilder.append("</SrcHeight>\n");
    localStringBuilder = this.a;
    localStringBuilder.append("    <ViewHeight>");
    localStringBuilder.append(this.c.getHeight());
    localStringBuilder.append("</ViewHeight>\n");
    localStringBuilder = this.a;
    localStringBuilder.append("    <LastY>");
    localStringBuilder.append(DragSortListView.x(this.c));
    localStringBuilder.append("</LastY>\n");
    localStringBuilder = this.a;
    localStringBuilder.append("    <FloatY>");
    localStringBuilder.append(DragSortListView.r(this.c));
    localStringBuilder.append("</FloatY>\n");
    this.a.append("    <ShuffleEdges>");
    i = 0;
    while (i < j)
    {
      localStringBuilder = this.a;
      localDragSortListView = this.c;
      localStringBuilder.append(DragSortListView.a(localDragSortListView, k + i, localDragSortListView.getChildAt(i).getTop()));
      localStringBuilder.append(",");
      i += 1;
    }
    this.a.append("</ShuffleEdges>\n");
    this.a.append("</DSLVState>\n");
    this.d += 1;
    if (this.d > 1000)
    {
      flush();
      this.d = 0;
    }
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mm/ui/widget/sortlist/DragSortListView$DragSortTracker:f	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 33	com/tencent/mm/ui/widget/sortlist/DragSortListView$DragSortTracker:e	I
    //   12: ifne +163 -> 175
    //   15: iconst_0
    //   16: istore_1
    //   17: goto +3 -> 20
    //   20: new 204	java/io/BufferedWriter
    //   23: dup
    //   24: new 206	java/io/OutputStreamWriter
    //   27: dup
    //   28: new 208	java/io/FileOutputStream
    //   31: dup
    //   32: aload_0
    //   33: getfield 50	com/tencent/mm/ui/widget/sortlist/DragSortListView$DragSortTracker:b	Ljava/io/File;
    //   36: iload_1
    //   37: invokespecial 211	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   40: ldc 213
    //   42: invokespecial 216	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   45: invokespecial 219	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   48: astore_2
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 29	com/tencent/mm/ui/widget/sortlist/DragSortListView$DragSortTracker:a	Ljava/lang/StringBuilder;
    //   54: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokevirtual 228	java/io/Writer:write	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 29	com/tencent/mm/ui/widget/sortlist/DragSortListView$DragSortTracker:a	Ljava/lang/StringBuilder;
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 29	com/tencent/mm/ui/widget/sortlist/DragSortListView$DragSortTracker:a	Ljava/lang/StringBuilder;
    //   69: invokevirtual 231	java/lang/StringBuilder:length	()I
    //   72: invokevirtual 235	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: invokevirtual 236	java/io/Writer:flush	()V
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 33	com/tencent/mm/ui/widget/sortlist/DragSortListView$DragSortTracker:e	I
    //   85: iconst_1
    //   86: iadd
    //   87: putfield 33	com/tencent/mm/ui/widget/sortlist/DragSortListView$DragSortTracker:e	I
    //   90: aload_2
    //   91: invokevirtual 239	java/io/Writer:close	()V
    //   94: return
    //   95: astore_2
    //   96: ldc 241
    //   98: aload_2
    //   99: ldc 243
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 246	com/tencent/mm/ui/f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: return
    //   109: astore_3
    //   110: goto +6 -> 116
    //   113: astore_3
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +23 -> 140
    //   120: aload_2
    //   121: invokevirtual 239	java/io/Writer:close	()V
    //   124: goto +16 -> 140
    //   127: astore_2
    //   128: ldc 241
    //   130: aload_2
    //   131: ldc 243
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 246	com/tencent/mm/ui/f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_3
    //   141: athrow
    //   142: aconst_null
    //   143: astore_2
    //   144: aload_2
    //   145: ifnull +21 -> 166
    //   148: aload_2
    //   149: invokevirtual 239	java/io/Writer:close	()V
    //   152: return
    //   153: astore_2
    //   154: ldc 241
    //   156: aload_2
    //   157: ldc 243
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 246	com/tencent/mm/ui/f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: return
    //   167: astore_2
    //   168: goto -26 -> 142
    //   171: astore_3
    //   172: goto -28 -> 144
    //   175: iconst_1
    //   176: istore_1
    //   177: goto -157 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	DragSortTracker
    //   16	161	1	bool	boolean
    //   48	43	2	localBufferedWriter	java.io.BufferedWriter
    //   95	4	2	localIOException1	IOException
    //   115	6	2	localObject1	Object
    //   127	4	2	localIOException2	IOException
    //   143	6	2	localObject2	Object
    //   153	4	2	localIOException3	IOException
    //   167	1	2	localIOException4	IOException
    //   109	1	3	localObject3	Object
    //   113	28	3	localObject4	Object
    //   171	1	3	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   90	94	95	java/io/IOException
    //   49	90	109	finally
    //   8	15	113	finally
    //   20	49	113	finally
    //   120	124	127	java/io/IOException
    //   148	152	153	java/io/IOException
    //   8	15	167	java/io/IOException
    //   20	49	167	java/io/IOException
    //   49	90	171	java/io/IOException
  }
  
  public void startTracking()
  {
    this.a.append("<DSLVStates>\n");
    this.e = 0;
    this.f = true;
  }
  
  public void stopTracking()
  {
    if (this.f)
    {
      this.a.append("</DSLVStates>\n");
      flush();
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.DragSortTracker
 * JD-Core Version:    0.7.0.1
 */