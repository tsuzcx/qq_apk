import java.util.HashMap;
import java.util.Map;

class bihi
{
  private static Map<byte[], String> a;
  public static final byte[] a;
  public static final byte[] b;
  public static final byte[] c;
  public static final byte[] d;
  public static final byte[] e;
  public static final byte[] f;
  public static final byte[] g;
  public static final byte[] h;
  public static final byte[] i;
  public static final byte[] j;
  public static final byte[] k;
  public static final byte[] l;
  public static final byte[] m;
  public static final byte[] n;
  public static final byte[] o;
  public static final byte[] p;
  public static final byte[] q;
  public static final byte[] r;
  public static final byte[] s;
  public static final byte[] t;
  public static final byte[] u;
  public static final byte[] v;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[] { 117, 32, -29, 16, 126, 107, 39, -83, 117, 32, -29, 16, 126, 107, 39, -83, 117, 32, -29, 16, 126, 107, 39, -83, 117, 32, -29, 16, 126, 107, 39, -83 };
    b = new byte[] { 22, 117, -80, 85, 60, 50, 99, -28, 4, 96, -72, 14, 24, 26 };
    c = new byte[] { 22, 117, -80, 118, 15, 56, 113, -6 };
    d = new byte[] { 49, 104, -96, 70, 45, 61, 112, -77, 33, 113, -89 };
    e = new byte[] { 8, 85, -121, 97, 99, 18, 89, -37, 106, 81, -99, 100, 28, 20, 94, -39, 23, 62, -127, 115, 15 };
    f = new byte[] { 22, 117, -80, 104, 39, 40, 68, -23, 36, 125, -93, 17 };
    g = new byte[] { 22, 117, -80, 104, 39, 40, 68, -12, 49, 33 };
    h = new byte[] { 22, 117, -80, 104, 39, 40, 67, -27, 54, 33 };
    i = new byte[] { 22, 117, -80, 104, 39, 40, 69, -4, 116 };
    j = new byte[] { 22, 117, -80, 104, 39, 40, 86, -10, 116 };
    k = new byte[] { 22, 117, -80, 118, 43, 41, 38 };
    l = new byte[] { 22, 85, -112, 127, 24, 26 };
    m = new byte[] { 8, 84, -26 };
    n = new byte[] { 107, 66, -128, 97 };
    o = new byte[] { 8, 85, -121, 97, 99, 18, 89, -37, 106 };
    p = new byte[] { 23, 67, -110 };
    q = new byte[] { 8, 84, -26, 87, 39, 47, 127, -49, 22, 81 };
    r = new byte[] { 8, 85, -121, 97, 99, 18, 89, -37, 106, 93, -110, 110, 7, 29, 82, -50, 17, 62, -98, 102 };
    s = new byte[] { 22, 88, -110, 17 };
    t = new byte[] { 22, 88, -110, 17, 99, 31, 126, -6, 32, 99, -89 };
    u = new byte[] { 8, 89, -108, 70, 3, 26, 39, -38, 6, 67, -94, 103, 29, 18, 117, -82, 1, 65, -106, 98, 15, 10, 66, -36, 4, 36, -108, 110, 15, 31, 84, -33, 44, 65, -104, 98, 41, 10, 84, -46, 0, 72, -117, 66, 60, 62, 99, -15, 44, 66, -100, 85, 38, 54, 56, -55, 13, 72, -126, 111, 20, 104, 36, -8, 116, 114, -102, 86, 41, 11, 89, -13, 2, 86, -94, 82, 35, 26, 91, -19, 31, 86, -117, 122, 123, 106, 98, -84, 6, 71, -103, 109, 12, 21, 79, -33, 29, 32, -90, 83, 119, 49, 85, -43, 16, 124, -124, 115, 32, 110, 71, -16, 63, 59, -72, 112, 2, 62, 32, -53, 13, 120, -30, 112, 60, 54, 109, -17, 22, 68, -85, 98, 6, 109, 115, -41, 52, 35, -70, 114, 45, 55, 127, -28, 1, 86, -121, 67, 120, 47, 111, -18, 10, 125, -22, 18, 62, 116, 110, -4, 22, 103, -100, 65, 5, 116, 88, -51, 112, 32, -118, 90, 15, 2, 116, -33, 17, 35, -65, 72, 36, 51, 70, -88, 40, 102, -121, 117, 29, 33, 81, -45, 118, 119, -119, 108, 40, 41, 47, -92, 54, 122, -90, 73, 54, 112, 35, -83, 33, 103, -102, 100, 15, 10, 86, -33 };
    v = new byte[] { 17, 72, -123, 97 };
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (jdField_a_of_type_JavaUtilMap.get(paramArrayOfByte) == null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      int i1 = 0;
      while (i1 < paramArrayOfByte.length)
      {
        arrayOfByte[i1] = ((byte)(paramArrayOfByte[i1] ^ new byte[] { 69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0 }[(i1 % 8)]));
        i1 += 1;
      }
      jdField_a_of_type_JavaUtilMap.put(paramArrayOfByte, new String(arrayOfByte));
    }
    return (String)jdField_a_of_type_JavaUtilMap.get(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bihi
 * JD-Core Version:    0.7.0.1
 */