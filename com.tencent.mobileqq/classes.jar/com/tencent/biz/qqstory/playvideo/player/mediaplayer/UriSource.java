package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

public class UriSource
  implements MediaSource
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Uri jdField_a_of_type_AndroidNetUri;
  private Map jdField_a_of_type_JavaUtilMap;
  private Uri jdField_b_of_type_AndroidNetUri;
  private Map jdField_b_of_type_JavaUtilMap;
  
  public UriSource(Context paramContext, Uri paramUri, Map paramMap)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public MediaExtractor a()
  {
    MediaExtractor localMediaExtractor = new MediaExtractor();
    localMediaExtractor.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaUtilMap);
    return localMediaExtractor;
  }
  
  public MediaExtractor b()
  {
    if (this.jdField_b_of_type_AndroidNetUri != null)
    {
      MediaExtractor localMediaExtractor = new MediaExtractor();
      localMediaExtractor.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidNetUri, this.jdField_b_of_type_JavaUtilMap);
      return localMediaExtractor;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.UriSource
 * JD-Core Version:    0.7.0.1
 */