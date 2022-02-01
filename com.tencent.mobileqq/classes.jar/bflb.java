import java.util.HashMap;

public class bflb
{
  private HashMap<Integer, bflc> a = new HashMap();
  
  public bflb()
  {
    this.a.put(Integer.valueOf(1), new bflc("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j13h02.png", 1L, 0, ""));
    this.a.put(Integer.valueOf(2), new bflc("https://pub.idqqimg.com/pc/misc/files/20200324/5a1434be69aa5a61dca2e97db65cf50b.png", 1101236949L, 0, ""));
    this.a.put(Integer.valueOf(3), new bflc("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j17n0g.png", 101786420L, 0, ""));
    this.a.put(Integer.valueOf(4), new bflc("https://pub.idqqimg.com/pc/misc/files/20191009/8e2e317d4dfb00cbf7765c38a049d4c1k1j16hii.png", 1104445552L, 0, ""));
    this.a.put(Integer.valueOf(5), new bflc("https://pub.idqqimg.com/pc/misc/files/20180702/b836834dfbe493017b8767425c0d23e8jj3xilnn.png", 101458937L, 0, ""));
    this.a.put(Integer.valueOf(6), new bflc("https://pub.idqqimg.com/pc/misc/files/20190620/da7e017785e02546d81a93f6885b7c3fjx4cf6io.png", 1108961705L, 0, ""));
  }
  
  public bflc a(int paramInt)
  {
    return (bflc)this.a.get(Integer.valueOf(paramInt));
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflb
 * JD-Core Version:    0.7.0.1
 */