import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class azot
{
  private static List<Integer> a = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(86), Integer.valueOf(852), Integer.valueOf(1), Integer.valueOf(7), Integer.valueOf(20), Integer.valueOf(27), Integer.valueOf(30), Integer.valueOf(32), Integer.valueOf(33), Integer.valueOf(34), Integer.valueOf(36), Integer.valueOf(39), Integer.valueOf(40), Integer.valueOf(41), Integer.valueOf(43), Integer.valueOf(44), Integer.valueOf(45), Integer.valueOf(46), Integer.valueOf(47), Integer.valueOf(48), Integer.valueOf(49), Integer.valueOf(51), Integer.valueOf(52), Integer.valueOf(53), Integer.valueOf(54), Integer.valueOf(55), Integer.valueOf(56), Integer.valueOf(57), Integer.valueOf(58), Integer.valueOf(60), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63), Integer.valueOf(65), Integer.valueOf(66), Integer.valueOf(81), Integer.valueOf(82), Integer.valueOf(84), Integer.valueOf(90), Integer.valueOf(91), Integer.valueOf(92), Integer.valueOf(93), Integer.valueOf(94), Integer.valueOf(95), Integer.valueOf(98), Integer.valueOf(213), Integer.valueOf(216), Integer.valueOf(218), Integer.valueOf(220), Integer.valueOf(221), Integer.valueOf(223), Integer.valueOf(224), Integer.valueOf(225), Integer.valueOf(226), Integer.valueOf(227), Integer.valueOf(228), Integer.valueOf(229), Integer.valueOf(230), Integer.valueOf(231), Integer.valueOf(232), Integer.valueOf(233), Integer.valueOf(234), Integer.valueOf(235), Integer.valueOf(236), Integer.valueOf(237), Integer.valueOf(239), Integer.valueOf(241), Integer.valueOf(242), Integer.valueOf(243), Integer.valueOf(244), Integer.valueOf(247), Integer.valueOf(248), Integer.valueOf(249), Integer.valueOf(251), Integer.valueOf(252), Integer.valueOf(253), Integer.valueOf(254), Integer.valueOf(255), Integer.valueOf(256), Integer.valueOf(257), Integer.valueOf(258), Integer.valueOf(260), Integer.valueOf(261), Integer.valueOf(262), Integer.valueOf(263), Integer.valueOf(264), Integer.valueOf(265), Integer.valueOf(266), Integer.valueOf(267), Integer.valueOf(268), Integer.valueOf(297), Integer.valueOf(350), Integer.valueOf(351), Integer.valueOf(352), Integer.valueOf(353), Integer.valueOf(354), Integer.valueOf(356), Integer.valueOf(357), Integer.valueOf(358), Integer.valueOf(359), Integer.valueOf(370), Integer.valueOf(371), Integer.valueOf(372), Integer.valueOf(373), Integer.valueOf(374), Integer.valueOf(375), Integer.valueOf(376), Integer.valueOf(377), Integer.valueOf(378), Integer.valueOf(380), Integer.valueOf(386), Integer.valueOf(420), Integer.valueOf(421), Integer.valueOf(423), Integer.valueOf(501), Integer.valueOf(502), Integer.valueOf(503), Integer.valueOf(504), Integer.valueOf(506), Integer.valueOf(507), Integer.valueOf(509), Integer.valueOf(591), Integer.valueOf(592), Integer.valueOf(593), Integer.valueOf(594), Integer.valueOf(596), Integer.valueOf(597), Integer.valueOf(598), Integer.valueOf(673), Integer.valueOf(674), Integer.valueOf(675), Integer.valueOf(676), Integer.valueOf(677), Integer.valueOf(679), Integer.valueOf(682), Integer.valueOf(685), Integer.valueOf(689), Integer.valueOf(853), Integer.valueOf(855), Integer.valueOf(856), Integer.valueOf(880), Integer.valueOf(886), Integer.valueOf(960), Integer.valueOf(961), Integer.valueOf(962), Integer.valueOf(963), Integer.valueOf(964), Integer.valueOf(965), Integer.valueOf(966), Integer.valueOf(967), Integer.valueOf(971), Integer.valueOf(972), Integer.valueOf(973), Integer.valueOf(974), Integer.valueOf(975), Integer.valueOf(992), Integer.valueOf(993), Integer.valueOf(994), Integer.valueOf(995), Integer.valueOf(996), Integer.valueOf(998), Integer.valueOf(1242), Integer.valueOf(1246), Integer.valueOf(1264), Integer.valueOf(1268), Integer.valueOf(1345), Integer.valueOf(1441), Integer.valueOf(1473), Integer.valueOf(1671), Integer.valueOf(1684), Integer.valueOf(1758), Integer.valueOf(1784), Integer.valueOf(1787), Integer.valueOf(1868), Integer.valueOf(1876), Integer.valueOf(1890) }));
  
  public static azos a(String paramString)
  {
    String str1 = "";
    String str2 = "";
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      str1 = (String)paramString.get(0);
      str2 = (String)paramString.get(1);
    }
    return new azos(str1, "", str2);
  }
  
  public static ArrayList<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replace(" ", "");
      Iterator localIterator;
      int i;
      if (paramString.startsWith("+"))
      {
        localIterator = a.iterator();
        while (localIterator.hasNext())
        {
          i = ((Integer)localIterator.next()).intValue();
          if (paramString.startsWith("+" + i))
          {
            localArrayList.add(String.valueOf(i));
            localArrayList.add(paramString.replace("+" + i, ""));
            break label170;
          }
        }
      }
      for (;;)
      {
        if (localArrayList.size() < 2)
        {
          localArrayList.add("");
          localArrayList.add(paramString);
        }
        return localArrayList;
        if (paramString.startsWith("00"))
        {
          localIterator = a.iterator();
          label170:
          if (!localIterator.hasNext()) {
            continue;
          }
          i = ((Integer)localIterator.next()).intValue();
          if (!paramString.startsWith("00" + i)) {
            break;
          }
          localArrayList.add(String.valueOf(i));
          localArrayList.add(paramString.replace("00" + i, ""));
          continue;
        }
        i = paramString.indexOf("-");
        if (i > 0)
        {
          localArrayList.add(paramString.substring(0, i));
          localArrayList.add(paramString.substring(i + 1, paramString.length()));
        }
        else
        {
          localArrayList.add("");
          localArrayList.add(paramString);
        }
      }
    }
    localArrayList.add("");
    localArrayList.add("");
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azot
 * JD-Core Version:    0.7.0.1
 */