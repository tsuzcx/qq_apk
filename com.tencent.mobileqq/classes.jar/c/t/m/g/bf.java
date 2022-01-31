package c.t.m.g;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class bf
  extends LinkedHashMap<String, String>
{
  bf()
  {
    super(8, 1.0F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<String, String> paramEntry)
  {
    return size() > 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bf
 * JD-Core Version:    0.7.0.1
 */