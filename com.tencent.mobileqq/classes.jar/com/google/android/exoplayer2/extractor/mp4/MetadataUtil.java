package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class MetadataUtil
{
  private static final String LANGUAGE_UNDEFINED = "und";
  private static final int SHORT_TYPE_ALBUM;
  private static final int SHORT_TYPE_ARTIST;
  private static final int SHORT_TYPE_COMMENT;
  private static final int SHORT_TYPE_COMPOSER_1;
  private static final int SHORT_TYPE_COMPOSER_2;
  private static final int SHORT_TYPE_ENCODER;
  private static final int SHORT_TYPE_GENRE;
  private static final int SHORT_TYPE_LYRICS;
  private static final int SHORT_TYPE_NAME_1 = Util.getIntegerCodeForString("nam");
  private static final int SHORT_TYPE_NAME_2 = Util.getIntegerCodeForString("trk");
  private static final int SHORT_TYPE_YEAR;
  private static final String[] STANDARD_GENRES = { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
  private static final String TAG = "MetadataUtil";
  private static final int TYPE_ALBUM_ARTIST;
  private static final int TYPE_COMPILATION;
  private static final int TYPE_COVER_ART;
  private static final int TYPE_DISK_NUMBER;
  private static final int TYPE_GAPLESS_ALBUM;
  private static final int TYPE_GENRE;
  private static final int TYPE_GROUPING;
  private static final int TYPE_INTERNAL;
  private static final int TYPE_RATING;
  private static final int TYPE_SORT_ALBUM;
  private static final int TYPE_SORT_ALBUM_ARTIST;
  private static final int TYPE_SORT_ARTIST;
  private static final int TYPE_SORT_COMPOSER;
  private static final int TYPE_SORT_TRACK_NAME;
  private static final int TYPE_TEMPO;
  private static final int TYPE_TRACK_NUMBER;
  private static final int TYPE_TV_SHOW;
  private static final int TYPE_TV_SORT_SHOW;
  
  static
  {
    SHORT_TYPE_COMMENT = Util.getIntegerCodeForString("cmt");
    SHORT_TYPE_YEAR = Util.getIntegerCodeForString("day");
    SHORT_TYPE_ARTIST = Util.getIntegerCodeForString("ART");
    SHORT_TYPE_ENCODER = Util.getIntegerCodeForString("too");
    SHORT_TYPE_ALBUM = Util.getIntegerCodeForString("alb");
    SHORT_TYPE_COMPOSER_1 = Util.getIntegerCodeForString("com");
    SHORT_TYPE_COMPOSER_2 = Util.getIntegerCodeForString("wrt");
    SHORT_TYPE_LYRICS = Util.getIntegerCodeForString("lyr");
    SHORT_TYPE_GENRE = Util.getIntegerCodeForString("gen");
    TYPE_COVER_ART = Util.getIntegerCodeForString("covr");
    TYPE_GENRE = Util.getIntegerCodeForString("gnre");
    TYPE_GROUPING = Util.getIntegerCodeForString("grp");
    TYPE_DISK_NUMBER = Util.getIntegerCodeForString("disk");
    TYPE_TRACK_NUMBER = Util.getIntegerCodeForString("trkn");
    TYPE_TEMPO = Util.getIntegerCodeForString("tmpo");
    TYPE_COMPILATION = Util.getIntegerCodeForString("cpil");
    TYPE_ALBUM_ARTIST = Util.getIntegerCodeForString("aART");
    TYPE_SORT_TRACK_NAME = Util.getIntegerCodeForString("sonm");
    TYPE_SORT_ALBUM = Util.getIntegerCodeForString("soal");
    TYPE_SORT_ARTIST = Util.getIntegerCodeForString("soar");
    TYPE_SORT_ALBUM_ARTIST = Util.getIntegerCodeForString("soaa");
    TYPE_SORT_COMPOSER = Util.getIntegerCodeForString("soco");
    TYPE_RATING = Util.getIntegerCodeForString("rtng");
    TYPE_GAPLESS_ALBUM = Util.getIntegerCodeForString("pgap");
    TYPE_TV_SORT_SHOW = Util.getIntegerCodeForString("sosn");
    TYPE_TV_SHOW = Util.getIntegerCodeForString("tvsh");
    TYPE_INTERNAL = Util.getIntegerCodeForString("----");
  }
  
  private static CommentFrame parseCommentAttribute(int paramInt, ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readInt();
    if (paramParsableByteArray.readInt() == Atom.TYPE_data)
    {
      paramParsableByteArray.skipBytes(8);
      paramParsableByteArray = paramParsableByteArray.readNullTerminatedString(i - 16);
      return new CommentFrame("und", paramParsableByteArray, paramParsableByteArray);
    }
    Log.w("MetadataUtil", "Failed to parse comment attribute: " + Atom.getAtomTypeString(paramInt));
    return null;
  }
  
  private static ApicFrame parseCoverArt(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readInt();
    if (paramParsableByteArray.readInt() == Atom.TYPE_data)
    {
      int j = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
      String str;
      if (j == 13) {
        str = "image/jpeg";
      }
      while (str == null)
      {
        Log.w("MetadataUtil", "Unrecognized cover art flags: " + j);
        return null;
        if (j == 14) {
          str = "image/png";
        } else {
          str = null;
        }
      }
      paramParsableByteArray.skipBytes(4);
      byte[] arrayOfByte = new byte[i - 16];
      paramParsableByteArray.readBytes(arrayOfByte, 0, arrayOfByte.length);
      return new ApicFrame(str, null, 3, arrayOfByte);
    }
    Log.w("MetadataUtil", "Failed to parse cover art attribute");
    return null;
  }
  
  public static Metadata.Entry parseIlstElement(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.getPosition();
    i = paramParsableByteArray.readInt() + i;
    int j = paramParsableByteArray.readInt();
    int k = j >> 24 & 0xFF;
    if ((k == 169) || (k == 65533)) {
      k = 0xFFFFFF & j;
    }
    try
    {
      Object localObject1;
      if (k == SHORT_TYPE_COMMENT)
      {
        localObject1 = parseCommentAttribute(j, paramParsableByteArray);
        return localObject1;
      }
      if ((k == SHORT_TYPE_NAME_1) || (k == SHORT_TYPE_NAME_2))
      {
        localObject1 = parseTextAttribute(j, "TIT2", paramParsableByteArray);
        return localObject1;
      }
      if ((k == SHORT_TYPE_COMPOSER_1) || (k == SHORT_TYPE_COMPOSER_2))
      {
        localObject1 = parseTextAttribute(j, "TCOM", paramParsableByteArray);
        return localObject1;
      }
      if (k == SHORT_TYPE_YEAR)
      {
        localObject1 = parseTextAttribute(j, "TDRC", paramParsableByteArray);
        return localObject1;
      }
      if (k == SHORT_TYPE_ARTIST)
      {
        localObject1 = parseTextAttribute(j, "TPE1", paramParsableByteArray);
        return localObject1;
      }
      if (k == SHORT_TYPE_ENCODER)
      {
        localObject1 = parseTextAttribute(j, "TSSE", paramParsableByteArray);
        return localObject1;
      }
      if (k == SHORT_TYPE_ALBUM)
      {
        localObject1 = parseTextAttribute(j, "TALB", paramParsableByteArray);
        return localObject1;
      }
      if (k == SHORT_TYPE_LYRICS)
      {
        localObject1 = parseTextAttribute(j, "USLT", paramParsableByteArray);
        return localObject1;
      }
      if (k == SHORT_TYPE_GENRE)
      {
        localObject1 = parseTextAttribute(j, "TCON", paramParsableByteArray);
        return localObject1;
      }
      if (k == TYPE_GROUPING)
      {
        localObject1 = parseTextAttribute(j, "TIT1", paramParsableByteArray);
        return localObject1;
        if (j == TYPE_GENRE)
        {
          localObject1 = parseStandardGenreAttribute(paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_DISK_NUMBER)
        {
          localObject1 = parseIndexAndCountAttribute(j, "TPOS", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_TRACK_NUMBER)
        {
          localObject1 = parseIndexAndCountAttribute(j, "TRCK", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_TEMPO)
        {
          localObject1 = parseUint8Attribute(j, "TBPM", paramParsableByteArray, true, false);
          return localObject1;
        }
        if (j == TYPE_COMPILATION)
        {
          localObject1 = parseUint8Attribute(j, "TCMP", paramParsableByteArray, true, true);
          return localObject1;
        }
        if (j == TYPE_COVER_ART)
        {
          localObject1 = parseCoverArt(paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_ALBUM_ARTIST)
        {
          localObject1 = parseTextAttribute(j, "TPE2", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_SORT_TRACK_NAME)
        {
          localObject1 = parseTextAttribute(j, "TSOT", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_SORT_ALBUM)
        {
          localObject1 = parseTextAttribute(j, "TSO2", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_SORT_ARTIST)
        {
          localObject1 = parseTextAttribute(j, "TSOA", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_SORT_ALBUM_ARTIST)
        {
          localObject1 = parseTextAttribute(j, "TSOP", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_SORT_COMPOSER)
        {
          localObject1 = parseTextAttribute(j, "TSOC", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_RATING)
        {
          localObject1 = parseUint8Attribute(j, "ITUNESADVISORY", paramParsableByteArray, false, false);
          return localObject1;
        }
        if (j == TYPE_GAPLESS_ALBUM)
        {
          localObject1 = parseUint8Attribute(j, "ITUNESGAPLESS", paramParsableByteArray, false, true);
          return localObject1;
        }
        if (j == TYPE_TV_SORT_SHOW)
        {
          localObject1 = parseTextAttribute(j, "TVSHOWSORT", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_TV_SHOW)
        {
          localObject1 = parseTextAttribute(j, "TVSHOW", paramParsableByteArray);
          return localObject1;
        }
        if (j == TYPE_INTERNAL)
        {
          localObject1 = parseInternalAttribute(paramParsableByteArray, i);
          return localObject1;
        }
      }
      Log.d("MetadataUtil", "Skipped unknown metadata entry: " + Atom.getAtomTypeString(j));
      return null;
    }
    finally
    {
      paramParsableByteArray.setPosition(i);
    }
  }
  
  private static TextInformationFrame parseIndexAndCountAttribute(int paramInt, String paramString, ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readInt();
    if ((paramParsableByteArray.readInt() == Atom.TYPE_data) && (i >= 22))
    {
      paramParsableByteArray.skipBytes(10);
      i = paramParsableByteArray.readUnsignedShort();
      if (i > 0)
      {
        String str = "" + i;
        paramInt = paramParsableByteArray.readUnsignedShort();
        paramParsableByteArray = str;
        if (paramInt > 0) {
          paramParsableByteArray = str + "/" + paramInt;
        }
        return new TextInformationFrame(paramString, null, paramParsableByteArray);
      }
    }
    Log.w("MetadataUtil", "Failed to parse index/count attribute: " + Atom.getAtomTypeString(paramInt));
    return null;
  }
  
  private static Id3Frame parseInternalAttribute(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    int j = -1;
    int i = -1;
    String str2 = null;
    String str1 = null;
    while (paramParsableByteArray.getPosition() < paramInt)
    {
      int m = paramParsableByteArray.getPosition();
      int k = paramParsableByteArray.readInt();
      int n = paramParsableByteArray.readInt();
      paramParsableByteArray.skipBytes(4);
      if (n == Atom.TYPE_mean)
      {
        str1 = paramParsableByteArray.readNullTerminatedString(k - 12);
      }
      else if (n == Atom.TYPE_name)
      {
        str2 = paramParsableByteArray.readNullTerminatedString(k - 12);
      }
      else
      {
        if (n == Atom.TYPE_data)
        {
          j = k;
          i = m;
        }
        paramParsableByteArray.skipBytes(k - 12);
      }
    }
    if ((!"com.apple.iTunes".equals(str1)) || (!"iTunSMPB".equals(str2)) || (i == -1)) {
      return null;
    }
    paramParsableByteArray.setPosition(i);
    paramParsableByteArray.skipBytes(16);
    return new CommentFrame("und", str2, paramParsableByteArray.readNullTerminatedString(j - 16));
  }
  
  private static TextInformationFrame parseStandardGenreAttribute(ParsableByteArray paramParsableByteArray)
  {
    int i = parseUint8AttributeValue(paramParsableByteArray);
    if ((i > 0) && (i <= STANDARD_GENRES.length)) {}
    for (paramParsableByteArray = STANDARD_GENRES[(i - 1)]; paramParsableByteArray != null; paramParsableByteArray = null) {
      return new TextInformationFrame("TCON", null, paramParsableByteArray);
    }
    Log.w("MetadataUtil", "Failed to parse standard genre code");
    return null;
  }
  
  private static TextInformationFrame parseTextAttribute(int paramInt, String paramString, ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readInt();
    if (paramParsableByteArray.readInt() == Atom.TYPE_data)
    {
      paramParsableByteArray.skipBytes(8);
      return new TextInformationFrame(paramString, null, paramParsableByteArray.readNullTerminatedString(i - 16));
    }
    Log.w("MetadataUtil", "Failed to parse text attribute: " + Atom.getAtomTypeString(paramInt));
    return null;
  }
  
  private static Id3Frame parseUint8Attribute(int paramInt, String paramString, ParsableByteArray paramParsableByteArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = parseUint8AttributeValue(paramParsableByteArray);
    if (paramBoolean2) {
      i = Math.min(1, i);
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (paramBoolean1) {
          return new TextInformationFrame(paramString, null, Integer.toString(i));
        }
        return new CommentFrame("und", paramString, Integer.toString(i));
      }
      Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + Atom.getAtomTypeString(paramInt));
      return null;
    }
  }
  
  private static int parseUint8AttributeValue(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.skipBytes(4);
    if (paramParsableByteArray.readInt() == Atom.TYPE_data)
    {
      paramParsableByteArray.skipBytes(8);
      return paramParsableByteArray.readUnsignedByte();
    }
    Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.MetadataUtil
 * JD-Core Version:    0.7.0.1
 */