package androidx.core.text.util;

import java.util.Comparator;

final class LinkifyCompat$1
  implements Comparator<LinkifyCompat.LinkSpec>
{
  public int compare(LinkifyCompat.LinkSpec paramLinkSpec1, LinkifyCompat.LinkSpec paramLinkSpec2)
  {
    if (paramLinkSpec1.start < paramLinkSpec2.start) {}
    do
    {
      return -1;
      if (paramLinkSpec1.start > paramLinkSpec2.start) {
        return 1;
      }
      if (paramLinkSpec1.end < paramLinkSpec2.end) {
        return 1;
      }
    } while (paramLinkSpec1.end > paramLinkSpec2.end);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.text.util.LinkifyCompat.1
 * JD-Core Version:    0.7.0.1
 */